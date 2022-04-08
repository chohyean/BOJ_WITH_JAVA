package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S5_7568_덩치 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static ArrayList<Big> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());

		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int weight = Integer.parseInt(tokens.nextToken());
			int height = Integer.parseInt(tokens.nextToken());
			list.add(new Big(weight, height));
		}
		
		int cnt;
		for(int i = 0; i < N; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if(list.get(i).weight < list.get(j).weight && list.get(i).height < list.get(j).height) {
					cnt++;
				}
			}
			output.append(cnt+1 + " ");
		}
		System.out.println(output);

	}
	
	static class Big{
		int weight;
		int height;
		
		public Big(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	}

}
