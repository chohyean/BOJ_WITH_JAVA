package com.boj.string;
import java.util.Scanner;

public class BOJ_B1_1259_팰린드롬수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		
		while(true) {
			String num = scanner.next();
			if(num.equals("0")) break;
			
			String pelin = "";
			for(int i = num.length()-1 ; i >= 0; i--) {
				pelin += num.charAt(i); 
			}
			
			if(num.equals(pelin)) {
				output.append("yes" + "\n");
			}else {
				output.append("no" + '\n');
			}
		}
		System.out.println(output);

	}

}
