import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int dx[] = {U,-D};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {S,0});
		boolean visited[] = new boolean[F+1];
		visited[S] = true;
		
		int ans = -1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int gang = cur[0];
			int w = cur[1];
			
			if(gang == G) {
				ans = w;
				break;
			}
			
			for(int i=0;i<2;i++) {
				int nx = gang+dx[i];
				
				if(nx<1 || nx>F || nx == gang || visited[nx])continue;
				queue.offer(new int[] {nx,w+1});
				visited[nx] = true;
			}
		}
		System.out.println(ans == -1 ? "use the stairs" : ans);
	}
}