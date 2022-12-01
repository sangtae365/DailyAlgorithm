import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void rep_comb(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<=N;i++) {
			numbers[cnt] = i;
			rep_comb(cnt+1,i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		
		rep_comb(0,1);
		System.out.println(sb);
	}
}
