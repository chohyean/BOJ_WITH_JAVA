import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_1920_수찾기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int[] A;
	static int M;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		
		M = Integer.parseInt(input.readLine());
		nums = new int[M];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j < N; j++) {
				if(j == N-1 && nums[i] != A[j]) { 
					output.append("0").append("\n");
					break;
				}
				if(nums[i] != A[j]) continue;
				
				output.append("1").append("\n");
				break;
			}
		}
		System.out.println(output);
		
		

	}

}
