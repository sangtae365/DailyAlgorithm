import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,V;
	static boolean[][] map;
	static boolean[] b_visited;
	static boolean[] d_visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		d_visited = new boolean[N+1];
		b_visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer a = new StringTokenizer(br.readLine());
			// 배열보다 1크게 들어온다
			int x = Integer.parseInt(a.nextToken());
			int y = Integer.parseInt(a.nextToken());
			
			map[x][y] = true;
			map[y][x] = true;
		}
		
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		b_visited[cur] = true;
		queue.offer(cur);
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			sb.append(cur).append(" ");
			
			for(int i=1;i<=N;i++) {
				if(map[cur][i] && !b_visited[i]) {
					b_visited[i] = true;
					queue.offer(i);
				}
			}			
		}		
	}

	private static void dfs(int cur) {
		d_visited[cur] = true;
		sb.append(cur).append(" ");
		
		for(int i=1;i<=N;i++) {
			if(map[cur][i] && !d_visited[i]) {
				dfs(i);
			}
		}
	}
}