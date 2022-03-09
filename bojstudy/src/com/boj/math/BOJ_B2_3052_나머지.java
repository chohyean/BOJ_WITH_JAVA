package com.boj.math;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_B2_3052_나머지 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		HashSet<Integer> num = new HashSet<Integer>();
		
		for(int i = 0; i < 10; i++) {
			num.add(scanner.nextInt() % 42);
		}

		System.out.println(num.size());
	}

}
