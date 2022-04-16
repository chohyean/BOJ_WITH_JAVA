package com.programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PGS_L1_K번째수 {
	
	static int[] array = {1, 5, 2, 6, 3, 7, 4};
	static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(array, commands)));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        List<Integer> list;
		int[] answer = new int[commands.length];
        for(int c = 0; c < commands.length; c++) {
        	int i = commands[c][0];
        	int j = commands[c][1];
        	int k = commands[c][2];
        	list = new ArrayList<Integer>();
        	
        	for(int n = i-1; n <= j-1; n++) {
        		list.add(array[n]);
        	}
        	Collections.sort(list);

        	answer[c] = list.get(k-1);
        }
        
        return answer;
    }

}
