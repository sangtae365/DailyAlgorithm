import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,max;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		System.out.println(max);
	}
	private static void bfs(int sx, int sy) {
		Queue<int []> queue = new LinkedList<>();
		queue.offer(new int[] {sx,sy});
		visited[sx][sy] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			cnt++;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || map[nx][ny] == 0)continue;
				queue.add(new int[] {nx,ny});
				visited[nx][ny] = true;
			}
		}
		max = Math.max(cnt, max);
	}
}
