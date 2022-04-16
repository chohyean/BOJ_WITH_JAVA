package com.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;

public class PGS_L2_전화번호목록 {

	static String[] phone_book = {"119", "97674223", "1195524421"};
	
	public static void main(String[] args) {
		
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) {
        	if(phone_book[i+1].startsWith(phone_book[i])) {
        		answer = false;
        		return answer;
        	}
        }
        return answer;
    }
	
	public static boolean solution2(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String number : phone_book) {
			map.put(number, 1);
		}
		
		for(String number : phone_book) {
			for(int i = 1; i < number.length(); i++) {
				String str = number.substring(0, i);
				if(map.containsKey(str)) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}

}
