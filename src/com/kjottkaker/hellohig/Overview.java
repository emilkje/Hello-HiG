package com.kjottkaker.hellohig;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Overview extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void open_quiz(View button1){
    	Intent i = new Intent(this, QuizMain.class);
        startActivity(i);
    }
}
