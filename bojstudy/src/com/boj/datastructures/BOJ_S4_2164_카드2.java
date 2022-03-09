package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S4_2164_카드2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static Queue<Integer> cards = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for(int i = 1; i <= N; i++) {
			cards.offer(i);
		}
		
		while(true) {
			if(cards.size() == 1) break;
			
			cards.poll();
			if(cards.size() == 1) {
				break;
			}else {
				cards.offer(cards.poll());
			}
		}
		
		System.out.println(cards.peek());
		

	}

}
