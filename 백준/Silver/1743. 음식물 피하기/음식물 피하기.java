import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, map[][], cnt;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}
		int max = 0;
		cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1) {
					dfs(i,j);
					max = Math.max(max, cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(max);		
	}
	private static void dfs(int x, int y) {
		if(visited[x][y])return;
		visited[x][y] = true;
		cnt++;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0)continue;
			dfs(nx,ny);
		}
	}
}