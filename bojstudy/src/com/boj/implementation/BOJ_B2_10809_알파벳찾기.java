package com.boj.implementation;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B2_10809_알파벳찾기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		
		int[] alphabet = new int[26];
		
		Arrays.fill(alphabet, -1);
		
		for(int i = 0; i < s.length(); i++) {
			if(alphabet[s.charAt(i) - 'a'] == -1) {
				alphabet[s.charAt(i) - 'a'] = i;
			}
		}
		
		for(int v : alphabet) {
			System.out.print(v + " ");
		}
	
	}

}
