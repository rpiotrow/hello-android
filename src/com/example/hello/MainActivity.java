package com.example.hello;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
        
      
        if (savedInstanceState == null) {
	        getSupportFragmentManager()
	        	.beginTransaction()
	        	.add(R.id.fragment_container, TextFragment.create("Hello fragment"))
	        	.commit();
        }
        	
    }

	private void buttonClick() {
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.fragment_container, TextFragment.create("New Fragment " + counter++))
			.addToBackStack(null)
			.commit();
	}

}
