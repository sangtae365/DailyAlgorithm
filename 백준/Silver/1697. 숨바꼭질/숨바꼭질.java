import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = {-1,1,2};
	static int ans;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		
		ans = Integer.MAX_VALUE;
		
		if(N==K)ans = 0;
		else bfs(N,K);
		
		System.out.println(ans);
	}
	private static void bfs(int n, int k) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {n,0});
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cur = temp[0];
			int cnt = temp[1];
			visited[cur] = true;
			
			if(cur == k) {
				ans = Math.min(ans, cnt);
				return;
			}
			
			for(int i=0;i<3;i++) {
				int nx = cur;
				if(i == 2) {
					nx *= dx[i];
				}else {
					nx += dx[i];
				}
				
				if(nx<0 || nx>100000 || visited[nx])continue;
				queue.offer(new int[] {nx, cnt+1});
			}
		}
	}
}