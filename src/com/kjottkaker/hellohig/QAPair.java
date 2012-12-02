package com.kjottkaker.hellohig;

public class QAPair {
	public String question;
	public String answer;
	public String alternative1;
	public String alternative2;
	public String alternative3;
	public QAPair(String q, String a, String w1, String w2, String w3) {
		question = new String(q);
		answer = new String(a);
		alternative1 = new String(w1);
		alternative2 = new String(w2);
		alternative3 = new String(w3);
	}
}
