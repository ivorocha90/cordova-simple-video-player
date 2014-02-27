package com.irdev.cordova.simplevideoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class SimpleVideoPlayerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("", "onCreate");
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_video_player);
		//VideoView videoView = (VideoView) findViewById(R.id.videoPlayerView);
		
		LinearLayout linearLayout = new LinearLayout(this);
		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		linearLayout.setLayoutParams(llp);
		linearLayout.setBackgroundColor(Color.parseColor("#000000"));
		
		VideoView videoView = new VideoView(this);
		LinearLayout.LayoutParams vLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		vLayout.gravity = Gravity.CENTER;
		videoView.setLayoutParams(vLayout);
		
		linearLayout.addView(videoView);
		setContentView(linearLayout);
		
		
		Uri uri = Uri.parse(getIntent().getExtras().getString("video_url"));
		Boolean useControls = getIntent().getExtras().getBoolean("user_controls");
		
		
		if(useControls){
			MediaController mediaController = new MediaController(this);
			videoView.setMediaController(mediaController);
			//mediaController.setAnchorView(videoView);
		}
		
		videoView.setVideoURI(uri);
		videoView.requestFocus();
		videoView.start();
		
	}


}