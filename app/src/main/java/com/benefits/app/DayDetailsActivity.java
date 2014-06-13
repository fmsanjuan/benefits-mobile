package com.benefits.app;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpRequestWrapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class DayDetailsActivity extends ListActivity {


    protected static final String TAG = DayDetailsActivity.class.getSimpleName();


    private List<Meal> mealList = new ArrayList<Meal>();
    Day day;
    String user;
    String pass;
    private Button backToDay;
    private Collection<Meals> meals = new ArrayList<Meals>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_details);

        day = (Day) getIntent().getExtras().get("day");
        user = getIntent().getExtras().getString("user");
        pass = getIntent().getExtras().getString("password");
        FetchSecuredResourceTask f = new FetchSecuredResourceTask(this, String.valueOf(day.getId()), user, pass);
        f.execute();



        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {

                Meals entry = (Meals) parent.getItemAtPosition(position);
                Intent i = new Intent(DayDetailsActivity.this,
                        MealDetailsActivity.class);
                if(entry.equals("Breakfast")){
                i.putExtra("meal", "BREAKFAST");}
                if(entry.equals("Mid Morning")){
                    i.putExtra("meal", "MID_MORNING");}
                if(entry.equals("Lunch")){
                    i.putExtra("meal", "LUNCH");}
                if(entry.equals("Tea Time")){
                    i.putExtra("meal", "TEA_TIME");}
                if(entry.equals("Dinner")){
                    i.putExtra("meal", "DINNER");}
                i.putExtra("dayId", day.getId());
                i.putExtra("user", getIntent().getExtras().getString("user") );
                i.putExtra("password", getIntent().getExtras().getString("password") );
                startActivity(i);

            };
        });


        backToDay = (Button) findViewById(R.id.backToDaysFromMeals);
        backToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    // ***************************************
    // Private classes
    // ***************************************
    private class FetchSecuredResourceTask extends AsyncTask<Integer, Void, Collection<String>> {

        Context mContext = null;
        final String url;

        String user;
        String pass;
        String dayId;
        Collection<Meals> mealsOfDay = new ArrayList<Meals>();

        Exception exception = null;

        FetchSecuredResourceTask(Context context, String dayId, String user, String pass) {
            mContext = context;
            this.dayId = dayId;
            this.user = user;
            this.pass = pass;
            url = getString(R.string.base_uri)
                    + "/rest/listmeals.do";
        }

        ProgressDialog progressDialog = new ProgressDialog(DayDetailsActivity.this);


        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Collection<String> doInBackground(Integer... arg0) {
            Collection<Meals> c = new ArrayList<Meals>();
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

                    ResponseEntity<Collection<String>> response = restTemplate.exchange(url,
                            HttpMethod.POST, request,
                            (Class<Collection<String>>)(Class<?>)Collection.class);

                    return response.getBody();

                } catch (HttpMessageNotReadableException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return new ArrayList<String>();
                } catch (HttpClientErrorException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return new ArrayList<String>();

                } catch (ResourceAccessException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return new ArrayList<String>();

                }

            } catch (Exception e) {
                Log.e("ClientServerDemo", "Error:", e);
                exception = e;
                return new ArrayList<String>();
            }


     }

        @Override
        protected void onPostExecute(Collection<String> result) {

            if (exception != null) {
                Toast.makeText(mContext, exception.getMessage(),
                        Toast.LENGTH_LONG).show();
            }


            for (String i : result) {
                if (!meals.contains(i)) {
                    if(i.equals("BREAKFAST")){
                        meals.add(Meals.BREAKFAST);}
                    if(i.equals("MID_MORNING")){
                        meals.add(Meals.MID_MORNING);}
                    if(i.equals("LUNCH")){
                        meals.add(Meals.LUNCH);}

                    if(i.equals("TEA_TIME")){
                        meals.add(Meals.TEA_TIME);}

                    if(i.equals("DINNER")){
                        meals.add(Meals.DINNER);}

                }


            }

            Vector<Meals> mealListToIndex = new Vector<Meals>(meals);
            setListAdapter(new AdapterMealList(DayDetailsActivity.this, mealListToIndex));
            progressDialog.dismiss();

        }

    }
}
