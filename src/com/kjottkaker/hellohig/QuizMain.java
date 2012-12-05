package com.kjottkaker.hellohig;

import java.util.Collections;
import java.util.Stack;

import android.os.Bundle;
import android.app.Activity;
//import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.kjottkaker.hellohig.QAPair;

public class QuizMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Globals g = Globals.getInstance();
        g.addQuestion(getResources().getString(R.string.q1), getResources().getString(R.string.a1), getResources().getString(R.string.w1n1), getResources().getString(R.string.w2n1), getResources().getString(R.string.w3n1));
        g.addQuestion(getResources().getString(R.string.q2), getResources().getString(R.string.a2), getResources().getString(R.string.w1n2), getResources().getString(R.string.w2n2), getResources().getString(R.string.w3n2));
        g.addQuestion(getResources().getString(R.string.q3), getResources().getString(R.string.a3), getResources().getString(R.string.w1n3), getResources().getString(R.string.w2n3), getResources().getString(R.string.w3n3));
        g.addQuestion(getResources().getString(R.string.q4), getResources().getString(R.string.a4), getResources().getString(R.string.w1n4), getResources().getString(R.string.w2n4), getResources().getString(R.string.w3n4));
        g.addQuestion(getResources().getString(R.string.q5), getResources().getString(R.string.a5), getResources().getString(R.string.w1n5), getResources().getString(R.string.w2n5), getResources().getString(R.string.w3n5));
        g.addQuestion(getResources().getString(R.string.q6), getResources().getString(R.string.a6), getResources().getString(R.string.w1n6), getResources().getString(R.string.w2n6), getResources().getString(R.string.w3n6));
        g.addQuestion(getResources().getString(R.string.q7), getResources().getString(R.string.a7), getResources().getString(R.string.w1n7), getResources().getString(R.string.w2n7), getResources().getString(R.string.w3n7));
        g.addQuestion(getResources().getString(R.string.q8), getResources().getString(R.string.a8), getResources().getString(R.string.w1n8), getResources().getString(R.string.w2n8), getResources().getString(R.string.w3n8));
        g.addQuestion(getResources().getString(R.string.q9), getResources().getString(R.string.a9), getResources().getString(R.string.w1n9), getResources().getString(R.string.w2n9), getResources().getString(R.string.w3n9));
        g.addQuestion(getResources().getString(R.string.q10), getResources().getString(R.string.a10), getResources().getString(R.string.w1n10), getResources().getString(R.string.w2n10), getResources().getString(R.string.w3n10));
        g.shuffle(); // Randomise the order of QAPs
        ask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz_main, menu);
        return true;
    }
    
    public void ask() {
    	Globals g = Globals.getInstance();
    	QAPair q = g.getQuestion(); // Get a QAP
    	setContentView(R.layout.activity_quiz_main);
    	// Headline/Question text
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(q.question);
        // Randomise answers
        Stack a = new Stack();
        a.push(new String(q.answer));
        a.push(new String(q.alternative1));
        a.push(new String(q.alternative2));
        a.push(new String(q.alternative3));
        Collections.shuffle(a);
        // Radio buttons
        RadioButton answer1 = (RadioButton) findViewById(R.id.answer1);
        answer1.setText((String) a.pop()); 
        RadioButton answer2 = (RadioButton) findViewById(R.id.answer2);
        answer2.setText((String) a.pop());
        RadioButton answer3 = (RadioButton) findViewById(R.id.answer3);
        answer3.setText((String) a.pop());
        RadioButton answer4 = (RadioButton) findViewById(R.id.answer4);
        answer4.setText((String)a.pop());
    }
    
    public void next(View next){
    	Globals g = Globals.getInstance();
    	if (g.getAsked() >= 10) {
    		//Intent i = new Intent(this, Result.class);
            //startActivity(i);
    		return;
    	}
    	RadioGroup answers = (RadioGroup) findViewById(R.id.group1);
    	int selected = answers.getCheckedRadioButtonId();
    	RadioButton answer = (RadioButton) findViewById(selected);
    	if (answer.getText() == g.getAnswer())
    		g.right();
        g.ask();
    	ask();
    }
}
