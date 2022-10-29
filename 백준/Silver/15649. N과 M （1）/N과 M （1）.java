import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,numbers[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		perm(0);
		System.out.println(sb);
	}
	public static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}