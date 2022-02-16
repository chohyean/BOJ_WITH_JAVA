import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int w, h; // 블록의 가로, 세로 길이
	private static int[][] block;
	private static int storeNum;
	private static int dir;
	private static int len;
	private static int[][] store;


	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		w = Integer.parseInt(tokens.nextToken());
		h = Integer.parseInt(tokens.nextToken());
		
		storeNum = Integer.parseInt(input.readLine());
		block = new int[h+1][w+1];
		
		for(int i = 1; i <= storeNum+1; i++) {
			tokens = new StringTokenizer(input.readLine());
			dir = Integer.parseInt(tokens.nextToken());
			len = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j < 2; j++) {
				if(dir == 1) {
					block[0][len] = i;
				}else if(dir ==2) {
					block[h][len] = i;
				}else if(dir == 3) {
					block[len][0] = i;
				}else if(dir == 4) {
					block[len][w] = i;
				}
			}
		} // 블록배열 속 자기 위치에 i를 넣어줌 (동근이는 storeNum + 1)

//		for(int[] row: block) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for(int r = 0; r < w+1; r++) {
			for(int c = 0; c < h+1; c++) {
				if(block[r][c] == 4) {
					
				}
			}
		}

	}

}
