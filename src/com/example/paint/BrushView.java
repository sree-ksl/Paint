package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class BrushView extends View{

	private Paint brush = new Paint();
	private Path path = new Path();
	public Button btnEraseAll;
	public LayoutParams params;
	
	
	
	public BrushView(Context context) {
		super(context);
		brush.setAntiAlias(true);
		brush.setColor(Color.BLUE);
		brush.setStyle(Paint.Style.STROKE);
		brush.setStrokeJoin(Paint.Join.ROUND);
		brush.setStrokeWidth(15f);
		
		btnEraseAll = new Button(context);
		btnEraseAll.setText("Erase!");
		
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		btnEraseAll.setLayoutParams(params);
	
		btnEraseAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			   path.reset();
			   //Invalidate the view
			   postInvalidate();
				
			}
		});
		
		
		
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		float pointX = event.getX();
		float pointY = event.getY();
		
		//check for the event that occurs
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			 path.moveTo(pointX, pointY);
			 return true;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(pointX, pointY);
			break;
		case MotionEvent.ACTION_UP:
			break;
		default:
			return false;
		}
		//Force a view to draw
		postInvalidate();
		return false;
	}

	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawPath(path, brush);
	}
}
