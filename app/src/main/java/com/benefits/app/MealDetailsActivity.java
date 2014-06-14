package com.benefits.app;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import org.codehaus.jackson.map.MappingJsonFactory;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class MealDetailsActivity extends ListActivity{

    protected static final String TAG = DayDetailsActivity.class.getSimpleName();

    private List<Amount> amountList = new ArrayList<Amount>();
    String user;
    String pass;
    String dayId;
    String mealName;

    private Button backToMeal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        user = getIntent().getExtras().getString("user");
        pass = getIntent().getExtras().getString("password");
        dayId = getIntent().getExtras().getString("dayId");
        mealName = getIntent().getExtras().getString("mealName");

        FetchSecuredResourceTask f = new FetchSecuredResourceTask(this, dayId, mealName,  user, pass);
        f.execute();

        backToMeal = (Button) findViewById(R.id.backToMealsFromAmounts);
        backToMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login,
                    container, false);
            return rootView;
        }
    }

    private class FetchSecuredResourceTask extends AsyncTask<Integer, Void, Meal> {

        Context mContext = null;
        final String url;

        String user;
        String pass;
        String dayId;
        String mealName;

        ProgressDialog progressDialog = new ProgressDialog(MealDetailsActivity.this);

        Exception exception = null;

        FetchSecuredResourceTask(Context context, String dayId, String mealName, String user, String pass) {
            mContext = context;
            this.dayId = dayId;
            this.user = user;
            this.pass = pass;
            this.mealName = mealName;
            url = getString(R.string.base_uri)
                    + "/rest/meal.do";
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            progressDialog.setMessage("Cargando...");
            progressDialog.show();
        }

        @Override
        protected Meal doInBackground(Integer... arg0) {
            try {

                _FakeX509TrustManager.allowAllSSL();

                HttpAuthentication authHeader = new HttpBasicAuthentication(
                        user, pass);

                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setAuthorization(authHeader);
                requestHeaders.setAccept(Collections
                        .singletonList(MediaType.APPLICATION_JSON));
                requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
                map.add("dayId", dayId);
                map.add("mealName", mealName);

                org.springframework.http.HttpEntity<MultiValueMap<String, String>> request =
                        new org.springframework.http.HttpEntity<MultiValueMap<String, String>>(map, requestHeaders);

                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate();
                List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
                messageConverters.add(new MappingJacksonHttpMessageConverter());
                messageConverters.add(new FormHttpMessageConverter());
                restTemplate.setMessageConverters(messageConverters);

                try {
                    // Make the network request
                    Log.d(TAG, url);

                    ResponseEntity<Meal> response = restTemplate.exchange(url,
                            HttpMethod.POST, request,
                            Meal.class);

                    return response.getBody();

                } catch (HttpMessageNotReadableException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return new Meal();
                } catch (HttpClientErrorException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return new Meal();

                } catch (ResourceAccessException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return new Meal();

                }

            } catch (Exception e) {
                Log.e("ClientServerDemo", "Error:", e);
                exception = e;
                return new Meal();
            }


        }

        @Override
        protected void onPostExecute(Meal result) {

            if (exception != null) {
                Toast.makeText(mContext, exception.getMessage(),
                        Toast.LENGTH_LONG).show();
            }


            Meal meal = (Meal) result;
            amountList.addAll(meal.getAmounts());

            getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position,
                                        long id) {
                };
            });
            Vector<Amount> amountListToIndex = new Vector<Amount>(amountList);
            setListAdapter(new AdapterAmountList(MealDetailsActivity.this, amountListToIndex));
            progressDialog.dismiss();

        }

    }

}
