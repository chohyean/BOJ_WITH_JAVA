package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_4047_영준이의카드카운팅 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int T;
	private static String S;
	private static int[][] cards;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int t = 1; t <= T; t++) {
			S = input.readLine();
			int len = S.length();
			cards = new int[4+1][13+1];
			
			for(int i = 0; i < len; i+=3) {
				String cs = S.substring(i, i+3);
				char cc = cs.charAt(0);
				int val = Integer.parseInt(cs.substring(1));
				switch (cc) {
					case 'S':
						cards[1][val]++;
						break;
					case 'D':
						cards[2][val]++;
						break;
					case 'H':
						cards[3][val]++;
						break;
					case 'C':
						cards[4][val]++;
						break;
				}
				
			}
			
			int[] cnt = new int[5];
			boolean isChecked = true;
			
			aa: for(int i = 1; i < 5; i++) {
				for(int j = 1; j < 14; j++) {
					if(cards[i][j] == 1) {
						cnt[i]++;
					}else if(cards[i][j] >= 2) {
						isChecked = false;
						break aa;
					}
				}
			}
			
			if(isChecked) {
				StringBuilder sb = new StringBuilder();
				sb.append("#" + t + " ");
				for(int i = 1; i < 5; i++) {
					sb.append((13-cnt[i]) + " ");
				}
				System.out.println(sb.toString());
			}else {
				System.out.println("#" + t + " ERROR");
			}
			
			
			
		}

	}
	
	private static String src = "3\n" + 
			"S01D02H03H04\n" + 
			"H02H10S11H02\n" + 
			"S10D10H10C01";

}
