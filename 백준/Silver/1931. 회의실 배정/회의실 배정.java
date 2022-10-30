import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int start,end;

		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			return this.end != o.end ?this.end - o.end : this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Node[] node = new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			node[i] = (new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Arrays.sort(node);	
		
		int end = node[0].end;
		int cnt = 1;
		for(int i=1;i<N;i++) {		
			if(node[i].start>=end) {
				end = node[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
}