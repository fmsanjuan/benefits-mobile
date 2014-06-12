package com.benefits.app;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Collections;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.net.ssl.SSLSocketFactory;

public class LoginActivity extends AbstractAsyncActivity {

	protected static final String TAG = LoginActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// Initiate the request to the protected service
		final Button submitButton = (Button) findViewById(R.id.submit);
		submitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new FetchSecuredResourceTask().execute();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
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

	// ***************************************
	// Private methods
	// ***************************************
	private void displayResponse(Plan result) {
		Toast.makeText(this, result.getId(), Toast.LENGTH_LONG).show();
	}

	// ***************************************
	// Private classes
	// ***************************************
	private class FetchSecuredResourceTask extends AsyncTask<Void, Void, Plan> {

		private String username;

		private String password;

		@Override
		protected void onPreExecute() {
			showLoadingProgressDialog();

			// build the message object
			EditText editText = (EditText) findViewById(R.id.username);
			this.username = editText.getText().toString();

			editText = (EditText) findViewById(R.id.password);
			this.password = editText.getText().toString();
		}

		@Override
		protected Plan doInBackground(Void... params) {
			final String url = getString(R.string.base_uri)
					+ "/rest/login.do";
			// final String url = getString(R.string.base_uri);

			// Populate the HTTP Basic Authentitcation header with the username
			// and password

            _FakeX509TrustManager.allowAllSSL();

			HttpAuthentication authHeader = new HttpBasicAuthentication(
					username, password);

			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAuthorization(authHeader);
			requestHeaders.setAccept(Collections
					.singletonList(MediaType.APPLICATION_JSON));

			// Create a new RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();
			MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
			restTemplate.getMessageConverters().add(converter);

			try {
				// Make the network request
				Log.d(TAG, url);
                ResponseEntity<Plan> response = restTemplate.exchange(url,
						HttpMethod.POST, new HttpEntity<Object>(requestHeaders),
						Plan.class);
                return response.getBody();

			} catch (HttpMessageNotReadableException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Plan();
			} catch (HttpClientErrorException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Plan();
			} catch (ResourceAccessException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Plan();
			}

		}

		@Override
		protected void onPostExecute(Plan result) {
//			dismissProgressDialog();
//			displayResponse(result);
            dismissProgressDialog();
            if(result != null){

            if(result.getId() == 0){
                onCancelled();
            }
            else {
                Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
                intent.putExtra("plan", result);
                intent.putExtra("user", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }}
            else{

                final TextView message = new TextView(LoginActivity.this);
                // i.e.: R.string.dialog_message =>
                // "Test this dialog following the link to dtmilano.blogspot.com"
                final SpannableString s =
                        new SpannableString((LoginActivity.this.getText(R.string.no_plan_error)) +"\n"+ (LoginActivity.this.getText((R.string.base_uri))));
                Linkify.addLinks(s, Linkify.WEB_URLS);
                message.setText(s);
                message.setMovementMethod(LinkMovementMethod.getInstance());

                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("Error")
                        .setCancelable(true)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setView(message)
                        .create().show();
            }



		}

        @Override
        protected void onCancelled() {
            final TextView message = new TextView(LoginActivity.this);
            // i.e.: R.string.dialog_message =>
            // "Test this dialog following the link to dtmilano.blogspot.com"
            final SpannableString s =
                    new SpannableString((LoginActivity.this.getText(R.string.no_plan_error)) +"\n"+ (LoginActivity.this.getText((R.string.base_uri))));
            Linkify.addLinks(s, Linkify.WEB_URLS);
            message.setText(s);
            message.setMovementMethod(LinkMovementMethod.getInstance());

            new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("Error")
                    .setCancelable(true)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setView(message)
                    .create().show();
        }

	}

}
