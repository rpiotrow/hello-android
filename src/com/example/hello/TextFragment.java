package com.example.hello;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
	
	private static final String ARG_CONTENT_STRING = "CONTENT_TEXT";

	public static TextFragment create(String content) {
		Bundle arguments = new Bundle();
		arguments.putString(ARG_CONTENT_STRING, content);
		
		TextFragment textFragment = new TextFragment();
		textFragment.setArguments(arguments);
		return textFragment;
	}
 
	private TextView contentTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.text_fragment, container, false);
		contentTextView = (TextView) view.findViewById(R.id.content);
		
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		contentTextView.setText(getArguments().getString(ARG_CONTENT_STRING));
	}

}
