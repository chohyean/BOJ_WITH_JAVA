package com.programmers.hash;

import java.util.HashMap;

public class PGS_L2_위장 {
	
	static String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

	public static void main(String[] args) {
		solution(clothes);

	}
	
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        System.out.println(map);

        for(String key : map.keySet()) {
        	answer *= map.get(key) + 1;
        }
        
        return answer-1;
    }

}
