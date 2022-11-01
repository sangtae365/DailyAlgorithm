import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, numbers[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		visited = new boolean[N];
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i])continue;
			
			visited[i] = true;
			numbers[cnt] = i+1;
			perm(cnt+1);
			visited[i] = false;
		}
	}
}