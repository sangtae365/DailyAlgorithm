import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		boolean visited[][] = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {0,0,0});
		visited[0][0] = true;
		
		int ans = 0;
		while(!dq.isEmpty()) {
			int temp[] = dq.poll();
			int x = temp[0];
			int y = temp[1];
			int w = temp[2];
			
			if(x == N-1 && y == M-1) {
				ans = w;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny])continue;
				visited[nx][ny] = true;
				if(map[nx][ny] == 0)dq.addFirst(new int[] {nx,ny,w});
				else dq.addLast(new int[] {nx,ny,w+1});
			}
		}
		System.out.println(ans);
	}
}