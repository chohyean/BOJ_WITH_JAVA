package com.boj.sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_S5_1181_단어정렬 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static ArrayList<String> words = new ArrayList<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = input.readLine();
			
			if(!words.contains(str)) {
				words.add(str);
			}
		}
		
		
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}else {
					return o1.length() - o2.length();
				}
			}
			
		});

		for(String w : words) {
			System.out.println(w);
		}

	}

}
