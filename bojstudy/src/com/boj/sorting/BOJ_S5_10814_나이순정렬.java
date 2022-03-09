package com.boj.sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_S5_10814_나이순정렬 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; 
	static ArrayList<Member> memberList = new ArrayList<Member>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int age = Integer.parseInt(tokens.nextToken());
			String name = tokens.nextToken();
			memberList.add(new Member(age, name));
		}
		
		Collections.sort(memberList);
		
		for(int i = 0; i < N; i++) {
			System.out.println(memberList.get(i).age + " " + memberList.get(i).name);
		}

	}
	
	static class Member implements Comparable<Member>{
		int age;
		String name;
		
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Member [age=" + age + ", name=" + name + "]";
		}

		@Override
		public int compareTo(Member o) {
			return this.age - o.age;
		}
		
		
		
		
	}

}
