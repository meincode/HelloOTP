package com.example.hellootp.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Config;
import android.util.Log;

public class UserNetworkInfo {
	Activity activity;
	String startURL = "http://www.nate.com";

	
	public UserNetworkInfo(Activity activity){
		this.activity = activity;
	}
	
	public int getNetworkInfo(){
		int resultcode = 0;
		// 네트워크 연결 체크 
	    ConnectivityManager cm = (ConnectivityManager)this.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
	    
	    if(cm.getActiveNetworkInfo()!=null){
	     NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
	     resultcode = activeNetwork.getType();
	     
	     switch(activeNetwork.getType()){
	     case ConnectivityManager.TYPE_WIMAX:
	    	 //Log.d("Test","Wibro 네트워크연결");
	    	 chkGpsService();
	    	 break;
	     case ConnectivityManager.TYPE_WIFI:
	    	 //Log.d("Test","WiFi 네트워크연결");
		    	 chkGpsService();
		    	 break;
	     case ConnectivityManager.TYPE_MOBILE:
	    	 //Log.d("Test","3G 네트워크연결");
	    	 chkGpsService();
	    	 break;    
	     }
	    }else{
	     Log.d("Test","네트워크연결 안됨");
	    }
	    return resultcode; 
	}

	
	public void getAlert(final Activity activity){
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		alertDialog.setTitle("네트워크 에러");
		alertDialog.setMessage("Wifi, 3G, Wibro 연결이 되지 않았습니다. 네트워크 연결을 확인해주세요");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				activity.finish();
				 //android.os.Process.killProcess(android.os.Process.myPid());
				}
			});
		
		alertDialog.show();
	}
	
	
	private void chkGpsService() {
		
	}
}
