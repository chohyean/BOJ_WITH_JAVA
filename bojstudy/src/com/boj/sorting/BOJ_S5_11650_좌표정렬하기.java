package com.boj.sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_S5_11650_좌표정렬하기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static ArrayList<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			list.add(new Point(x, y));
		}
		
		Collections.sort(list);

		for(int i = 0; i < N; i++) {
			output.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
		}
		System.out.println(output);
	}
	
	static class Point implements Comparable<Point>{
		int x = 0;
		int y = 0;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Point o) {
			
			if(this.x == o.x) {
				return this.y - o.y;
			}else {
				return this.x - o.x;
			}
			
		}
		
		
	}

}
