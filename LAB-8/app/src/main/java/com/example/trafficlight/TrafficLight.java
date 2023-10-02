package com.example.trafficlight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TrafficLight extends View {

    final static int RED = Color.RED;
    final static  int GREEN = Color.GREEN;
    final static int YELLOW = Color.YELLOW;
    final static int DEFT=Color.WHITE;
    int currentLight=Color.RED;

    public TrafficLight(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        // Create a Paint object for specifying the rectangle's color and style
        Paint rectanglePaint = new Paint();
        rectanglePaint.setColor(Color.BLACK); // Set the color to black
        rectanglePaint.setStyle(Paint.Style.FILL); // Set the style to fill

        // Create a Paint object for specifying the circle's color and style
        Paint circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.FILL);

        // Calculate the rectangle's dimensions
        float rectLeft = width / 4f;
        float rectTop = height / 8f;
        float rectRight = width * 3 / 4f;
        float rectBottom = height * 7 / 8f;

        // Calculate the radius of the circles
        float circleRadius = 150;

        // Calculate the x-coordinate for the circles, centered horizontally
        float circleX = width / 2f;

        // Calculate the y-coordinates for the circles, vertically aligned within the rectangle
        float circleY1 = height / 4f;
        float circleY2 = height / 2f;
        float circleY3 = height * 3 / 4f;

        // Draw the rectangle on the canvas
        canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, rectanglePaint);

        // Draw the three circles inside the rectangle
        circlePaint.setColor(currentLight == RED ? RED : DEFT);
        canvas.drawCircle(circleX, circleY1, circleRadius, circlePaint);

        circlePaint.setColor(currentLight == YELLOW ? YELLOW : DEFT);
        canvas.drawCircle(circleX, circleY2, circleRadius, circlePaint);

        circlePaint.setColor(currentLight == GREEN ? GREEN : DEFT);
        canvas.drawCircle(circleX, circleY3, circleRadius, circlePaint);
    }

    void changeLight(){
        if(currentLight == RED){
            currentLight = GREEN;
        } else if (currentLight == GREEN) {
            currentLight = YELLOW;
        } else if (currentLight == YELLOW) {
            currentLight = RED;
        } else {
            currentLight = RED;
        }
        invalidate(); // Redraw the TrafficLight
    }
}