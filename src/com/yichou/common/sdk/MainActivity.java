package com.yichou.common.sdk;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * 
 * @author Yichou
 *
 */
public class MainActivity extends ListActivity {
	static final String[] ITEMS = {
		"自动更新",
		"反馈"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ITEMS));
		
//		System.loadLibrary(libName)
//		info.applicationInfo.metaData
	}
	
	@Override
	protected void onResume() {
		SdkUtils.getSdk().onResume(this);
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		SdkUtils.getSdk().onPause(this);
		
		super.onPause();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		if(position == 0) {
			SdkUtils.getSdk().checkUpdate(this);
		} else if (position == 1) {
			UmengSdkImpl.startFeedbackActivity(this);
		}
	}
}
