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
        Globals g = Globals.getInstance();/*
        g.addQuestion("I hvilket bygg ligger Ørneredet?", "G-bygget", "A-bygget", "H-bygget", "C-bygget");
        g.addQuestion("Hva heter dekanen på IMT?", "Morten Irgens", "Harald Liodden", "Simon McCallum", "Det er en felles dekan for IMT, HOS og TØL");
        g.addQuestion("Når stenger biblioteket?", "19:00", "Det er alltid åpent", "20:00", "18:00");
        g.addQuestion("Når åpner kantina?", "08:00", "07:00", "09:00", "07:30");
        g.addQuestion("I hvilken etasje i A-bygget finner man toalettene?", "I kjelleren", "I  1. etasje", "I 2. etasje", "Det er ikke toaletter i A-bygget");
        g.addQuestion("Når stenger middagsserveringa i kantina på fredager?", "13:30", "15:00", "16:00", "16:30");
        g.addQuestion("I hvilket bygg finner du IT-tjenesten?", "K-bygget", "A-bygget", "G-bygget", "H-bygget");
        g.addQuestion("Hvilket bygg ligger kantina i?", "G-bygget", "A-bygget", "K-bygget", "B-bygget");
        g.addQuestion("Hva heter studenthuset for HiG-studentene?", "Huset", "Studenthuset", "Studentenes hus", "HiG-huset");
        g.addQuestion("I hvilket bygg ligger Eureka?", "H-bygget", "A-bygget", "B-bygget", "G-bygget");*/
        g.addQuestion(getResources().getString(R.string.test), "H-bygget", "A-bygget", "B-bygget", "G-bygget");
        //R.string.string_name
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
