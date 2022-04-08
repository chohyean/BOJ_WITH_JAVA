package com.boj.sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_S5_11651_좌표정렬하기2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static ArrayList<Point> points = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			points.add(new Point(x, y));
		}
		
		Collections.sort(points);
		
		for(int i = 0; i < N; i++) {
			output.append(points.get(i).x).append(" ").append(points.get(i).y).append("\n");
		}
		System.out.println(output);

	}
	
	static class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Point o) {
			if(this.y == o.y) {
				return this.x - o.x;
			}else {
				return this.y - o.y;
			}
		}
		
		
	}

}
