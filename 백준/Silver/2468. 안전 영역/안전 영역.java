import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], max;
	static boolean visited[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int height = 0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(height, map[i][j]);
			}
		}
		int cnt = 0;
		int ans = 0;
		while(cnt<height) {
			int max = 0;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]>cnt) {
						dfs(i,j,cnt);
						max++;
					}
				}
			}
			cnt++;
			ans = Math.max(ans, max);
		}
		
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int limit) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]<=limit)continue;
			dfs(nx,ny,limit);
		}
	}
}