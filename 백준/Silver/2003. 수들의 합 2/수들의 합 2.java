import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, sum = 0, ans = 0;
		while(true) {
			if(sum>=M) {
				sum-=num[start++];
			}else if(end == N)break;
			else if(sum<M) {
				sum+=num[end++];
			}
			if(sum == M)ans++;
		}
		System.out.println(ans);
	}
}