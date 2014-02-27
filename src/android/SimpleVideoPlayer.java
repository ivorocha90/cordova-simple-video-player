package com.irdev.cordova.simplevideoplayer;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.os.Bundle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;

public class SimpleVideoPlayer extends CordovaPlugin  {

	
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    	PluginResult.Status status = PluginResult.Status.OK;
        String result = "";
        
        if (action.equals("play")) {
            Intent intent = new Intent(this.cordova.getActivity(), SimpleVideoPlayerActivity.class);
            Bundle b = new Bundle();
            b.putString("video_url", args.getString(0)); 
            LOG.d("length", "" + args.length());
            LOG.d("value", "" + args.getBoolean(1));
            b.putBoolean("user_controls", args.length() >= 2 ? args.getBoolean(1) : true);
            intent.putExtras(b); //Put your id to your next Intent
			this.cordova.getActivity().startActivity(intent);
			status = PluginResult.Status.OK;
        }
        else {
            status = PluginResult.Status.INVALID_ACTION;
        }
        
        callbackContext.sendPluginResult(new PluginResult(status, result));
		
        return false;
	}
	
}