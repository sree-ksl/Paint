package com.example.paint;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PaintActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BrushView view=new BrushView(this);
		setContentView(view);
		addContentView(view.btnEraseAll, view.params);
	}

	@Override
	protected void onPause(){
		super.onPause();
		finish();
	}

}
