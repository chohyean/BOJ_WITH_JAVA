package com.boj.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_15829_Hashing {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int L;
	static String str;
	static long pow = 1;
	static long hash = 0;
	static final int con = 1234567891; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		L = Integer.parseInt(input.readLine());
		str = input.readLine();
		for(int i = 0; i < L; i++) {
			long num = str.charAt(i)-'a'+1;
			hash += (num * pow) % con;
			pow = (pow * 31) % con;
		}
		
		hash %= con;
		System.out.println(hash);

	}

}
