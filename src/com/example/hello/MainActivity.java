package com.example.hello;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
        
        findViewById(R.id.add_fragment_button).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				buttonClick();
			}
		});
        
      
        //if (savedInstanceState == null) {
        	FragmentTransaction fragmentManagerTransaction =
        			getSupportFragmentManager()
        			.beginTransaction();
        	fragmentManagerTransaction
	        	.add(R.id.fragment_container, TextFragment.create("Hello fragment"));
	        if (findViewById(R.id.fragment_container_two) != null) {
	        	Log.i("lalal", "przed");
	        	fragmentManagerTransaction
	        		.add(R.id.fragment_container_two, TextFragment.create("Hello fragment Two"));
	        	Log.i("lalal", "po");
	        }
	        fragmentManagerTransaction.commit();
        //}
        	
    }

	private void buttonClick() {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction
			.replace(R.id.fragment_container, TextFragment.create("New Fragment " + counter++));
		if (findViewById(R.id.fragment_container_two) != null) {
			transaction
				.replace(R.id.fragment_container_two, TextFragment.create("New Fragment " + counter++));
		}
		transaction
			.addToBackStack(null)
			.commit();
	}

}
