import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1743_음식물피하기 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int N, M, K; // 통로의 세로 길이, 가로 길이, 음식물 쓰레기 개수
	private static int[][] floor;
	private static int cnt, answer;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		floor = new int[N][M];
		for(int i = 0; i < K; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			floor[x-1][y-1] = 1;
		}
		// 입력완료
		
		answer = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				cnt = 0;
				if(dfs(r, c)) {
					if(answer < cnt) answer = cnt;
				}
			}
		}
		
		System.out.println(answer);

	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	// 특정 노드 방문하고 연결된 모든 노드들도 방문!
	public static boolean dfs(int r, int c) {
		
		if(!isIn(r, c)) return false;
		// 현재 노드를 아직 방문하지 않았으면
		if(floor[r][c] == 1) {
			// 해당 노드 방문 처리
			floor[r][c] = 0;
			cnt++;
			// 상, 하, 좌, 우의  위치들도 모두 재귀호출
			dfs(r-1, c);
			dfs(r, c-1);
			dfs(r+1, c);
			dfs(r, c+1);
			return true;
		}
		return false;
	}

}
