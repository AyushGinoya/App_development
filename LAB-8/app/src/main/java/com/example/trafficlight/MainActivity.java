package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends AppCompatActivity {

    private boolean isTrafficLightRunning = true;
    private TrafficLight light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create an instance of your custom view  ---> TrafficLight
        light = new TrafficLight(this);

        // Set the content view to your custom view
        //The first parameter is the view that you want to set as the content view for the activity. This can be a layout defined in XML or a custom view like light in your code.
        //
        //The second parameter is an instance of ViewGroup.LayoutParams, which defines how the view should be laid out within the activity's content area. Commonly used values for the width and height are LayoutParams.MATCH_PARENT (fills the parent container) and LayoutParams.WRAP_CONTENT (sizes the view based on its content).
        setContentView(light, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        startLight();
    }

    private void startLight() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                light.changeLight();
                light.invalidate();
                if (isTrafficLightRunning) {
                    startLight(); // Continue changing the light every 3 seconds
                }
            }
        }, 3000); // 3 seconds
    }

    //This method to stop the traffic light cycle
    private void stopLight() {
        isTrafficLightRunning = false;
    }
}
