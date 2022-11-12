import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int input[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		System.out.println(ans);
	}
	
	public static void dfs(int cnt, int last, int sum) {
		if(cnt == N) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i=0;i<N;i++) {		
			if(visited[i])continue;
			visited[i] = true;
			dfs(cnt+1, input[i], cnt==0?0:sum+(int)Math.abs(last-input[i]));
			visited[i] = false;
		}
	}
}
