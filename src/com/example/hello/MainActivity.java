package com.example.hello;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button urlButton = (Button) findViewById(R.id.url_button);
        urlButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startUriIntent("http://www.onet.pl");
			}
		});
        
        Button googleMapTargetButton = (Button) findViewById(R.id.google_map_button);
        googleMapTargetButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startUriIntent("geo:51.10780,17.03150?z=20");
			}
		});
    }

	private void startUriIntent(String uri) {
		
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(uri));
		startActivity(intent);
	}

}
