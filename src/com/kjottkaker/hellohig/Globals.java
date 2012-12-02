package com.kjottkaker.hellohig;

import java.util.Collections;
import java.util.Stack;

import com.kjottkaker.hellohig.QAPair;

public class Globals {
	private static Globals instance;
	private Stack QAP = new Stack();
	private QAPair activeQAP;
	private int asked = 0;
	private int right = 0;
	private Globals(){}
	
	public void addQuestion(String q, String a, String w1, String w2, String w3) {
	     QAP.push(new QAPair(q, a, w1, w2, w3));
	}
	
	public QAPair getQuestion() {
		activeQAP = (QAPair) this.QAP.pop();
	    return activeQAP;
	} 
	
	public String getAnswer() {
		return activeQAP.answer;
	}
	
	public void shuffle() {
		Collections.shuffle(QAP);
	}
	
	public void ask() {
		++asked;
	}
	
	public int getAsked() {
		return asked;
	}
	
	public void right() {
		++right;
	}
	
	public int getRight() {
		return right;
	}
	
	public static synchronized Globals getInstance() {
	     if(instance==null){
	       instance=new Globals();
	     }
	     return instance;
	 }
}