import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Paper{
		int loc, imp;

		public Paper(int loc, int imp) {
			this.loc = loc;
			this.imp = imp;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Paper> queue = new LinkedList<Paper>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			queue.clear();
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int impo = 0;
			st = new StringTokenizer(br.readLine());
			
			Integer x[] = new Integer[N];
			for(int i=0;i<N;i++) {
				x[i] = Integer.parseInt(st.nextToken());
				queue.offer(new Paper(i,x[i]));
				if(i == M)impo = x[i];
			}
			Arrays.sort(x,Collections.reverseOrder());
			int cnt = 0;
			int num = 0;
			while(!queue.isEmpty()) {
				Paper paper = queue.poll();
				int loc = paper.loc;
				int imp = paper.imp;
				if(imp == impo && loc == M && x[num] == impo) {	
					cnt++;
					break;
				}				
				if(imp == x[num]) {
					num++;
					cnt++;
				}else {
					queue.offer(paper);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
