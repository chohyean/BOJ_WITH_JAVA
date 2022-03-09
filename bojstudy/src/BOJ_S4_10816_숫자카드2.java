import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * 시간초과 조심! 
 * @author hyeancho
 *
 */
public class BOJ_S4_10816_숫자카드2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; // 숫자카드의 개수 
	static int[] cards; // 숫자카드에 적혀있는 정수 배열 
	static HashMap<Integer, Integer> datas = new HashMap<>();
	static int M; // 답 구해야 할 개수 
	static int[]  nums; // 몇개 가지고 있는 숫자카드인지 구해야 할 정수 배열 
	
	
	static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		cards = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			int keyNum = Integer.parseInt(tokens.nextToken());
			datas.put(keyNum, datas.getOrDefault(keyNum, 0)+1);
		}
		M = Integer.parseInt(input.readLine());
		nums = new int[M];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int n : nums) {
			output.append(datas.getOrDefault(n, 0)).append(" ");
		}
		System.out.println(output);

	}

}
