package com.example.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCanvas extends View {

    Paint paint;
    boolean check = false;
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    float x,y;
    public MyCanvas(Context context) {
        super(context);
        init();
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.FILL);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = 100;  // Circle radius

        if(!check){
            x= getWidth() / 2;  // Center X-coordinate
            y = getHeight() / 2; // Center Y-coordinate
            canvas.drawColor(Color.WHITE);
            canvas.drawCircle(x, y, radius, paint);  // Draw circle
        } else if(left){
            x=x-30;
            canvas.drawColor(Color.WHITE);
            canvas.drawCircle(x, y, radius, paint);  // Draw circle
        } else if(right){
            x=x+30;
            canvas.drawColor(Color.WHITE);
            canvas.drawCircle(x, y, radius, paint);  // Draw circle
        } else if (up) {
            y=y+30;
            canvas.drawColor(Color.WHITE);
            canvas.drawCircle(x, y, radius, paint);  // Draw circle
        } else if (down) {
            y=y-30;
            canvas.drawColor(Color.WHITE);
            canvas.drawCircle(x, y, radius, paint);  // Draw circle
        }

    }
}
