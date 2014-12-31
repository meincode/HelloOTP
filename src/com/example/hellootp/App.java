package com.example.hellootp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class App extends Application {
	private static final String TAG = App.class.getSimpleName();
	private static App instance;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "App.onCreate was called");
		instance = this;
	}
	
	public static Context getContext() {
		return instance.getApplicationContext();
	}
}
