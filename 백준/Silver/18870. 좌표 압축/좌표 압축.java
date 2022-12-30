import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		X[] x = new X[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			x[i] = new X(i,Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(x);
		
		int cnt = 0;
		int ans[] = new int[N];
		ans[x[0].index] = 0;
		for(int i=1;i<N;i++) {
			if(x[i].num != x[i-1].num) {
				ans[x[i].index] = ++cnt;
			}else {
				ans[x[i].index] = cnt;
			}
		}	

		for(int i=0;i<N;i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
		
	}	
	
	static class X implements Comparable<X>{
		int num,index;

		public X(int index, int num) {
			super();
			this.index = index;
			this.num = num;
		}
		
		@Override
		public int compareTo(X o) {
			return this.num - o.num;		// 오름차순
		}
		
	}
}