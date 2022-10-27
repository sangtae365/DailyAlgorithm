import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,map[][],ans;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		visited = new boolean[N];
		comb(0,0);
		System.out.println(ans);
	}
	public static void comb(int cnt, int start) {
		if(cnt == N/2) {
			diff();
			return;
		}
		
		for(int i=start;i<N;i++) {
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
	public static void diff() {
		int start = 0;
		int link = 0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i] && visited[j]) {
					start += (map[i][j] + map[j][i]);
				}else if(!visited[i] && !visited[j]) {
					link += (map[i][j] + map[j][i]);
				}
			}
		}
		
		ans = Math.min(ans, Math.abs(start -link));
		if(ans == 0) {
			System.out.println(ans);
			System.exit(0);
		}
	}
}