package com.boj.implementation;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B2_1152_단어의개수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		String[] arr = str.trim().split(" ");
		
		if(str.trim().isEmpty()) { // str에 아무것도 없으면 0 출력 
			System.out.println(0);
		}else {
			System.out.println(arr.length);
		}
	}

}
