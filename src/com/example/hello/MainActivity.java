package com.example.hello;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity {

	private int counter = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.add_fragment_button).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View view) {
						buttonClick();
					}
				});

		// if (savedInstanceState == null) {
		FragmentTransaction fragmentManagerTransaction = getSupportFragmentManager()
				.beginTransaction();
		fragmentManagerTransaction.add(R.id.fragment_container,
				TextFragment.create("Hello fragment"));
		if (findViewById(R.id.fragment_container_two) != null) {
			Log.i("lalal", "przed");
			fragmentManagerTransaction.add(R.id.fragment_container_two,
					TextFragment.create("Hello fragment Two"));
			Log.i("lalal", "po");
		}
		fragmentManagerTransaction.commit();
		// }

	}

	private void buttonClick() {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container,
				TextFragment.create("New Fragment " + counter++));
		if (findViewById(R.id.fragment_container_two) != null) {
			transaction.replace(R.id.fragment_container_two,
					TextFragment.create("New Fragment " + counter++));
		}
		transaction.addToBackStack(null).commit();
		
		
		new MyLongTask().execute();
	}

	private class MyLongTask extends AsyncTask<String, Integer, Integer> {

		private ProgressDialog pd;

		@Override
		protected void onPreExecute() {

			pd = new ProgressDialog(MainActivity.this);
			
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.setMax(5);
			pd.setTitle("title");
			pd.setMessage("message");
			
			pd.show();
			
			//pd = ProgressDialog.show(MainActivity.this, "title", "In Progress",
				//	true);
		}

		@Override
		protected void onPostExecute(Integer result) {

			pd.cancel();
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			
			pd.setProgress(values[values.length -1]);
		
		}

		@Override
		protected Integer doInBackground(String... params) {

			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				publishProgress(i);
			}

			return null;
		}

	}

}
