package com.benefits.app;

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

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
						HttpMethod.GET, new HttpEntity<Object>(requestHeaders),
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
			dismissProgressDialog();
			displayResponse(result);
		}

	}

}
