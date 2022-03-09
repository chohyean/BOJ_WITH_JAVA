package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_S2_2304_창고다각형 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static ArrayList<Column> list = new ArrayList<Column>();
	static int maxHeight = Integer.MIN_VALUE;
	static int maxDir = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int L = Integer.parseInt(tokens.nextToken());
			int H = Integer.parseInt(tokens.nextToken());
			list.add(new Column(L, H));
			if(maxHeight < H) maxHeight = H;
		}
		
		Collections.sort(list, new Comparator<Column>() {
			@Override
			public int compare(Column o1, Column o2) {
				return o1.dir - o2.dir;
			}
		});
//		System.out.println(list);
		
		for(int i = 0; i < N; i++) {
			if(list.get(i).height == maxHeight) {
				maxDir = i;
				break;
			}
		}
		
		int area = 0;
		for(int i = 0; i < maxDir; i++) {
			for(int j = i+1; j <= maxDir; j++) {
				if(list.get(i).height <= list.get(j).height) {
					area += (list.get(j).dir - list.get(i).dir) * list.get(i).height;
					i = j;
				}
			}
		}
		
		for(int i = N-1; i > maxDir; i--) {
			for(int j = i-1; j >= maxDir; j--) {
				if(list.get(i).height <= list.get(j).height) {
					area += (list.get(i).dir - list.get(j).dir) * list.get(i).height;
					i = j;
				}
			}

		}
		
		System.out.println(area + maxHeight);

	}
	
	static class Column {
		int dir = 0;
		int height = 0;
		
		public Column(int dir, int height) {
			super();
			this.dir = dir;
			this.height = height;
		}

		@Override
		public String toString() {
			return "[dir=" + dir + ", height=" + height + "]";
		}
	}

}
