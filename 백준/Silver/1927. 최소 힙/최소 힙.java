import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class Node implements Comparable<Node>{
		int r_num, num;

		public Node(int r_num, int num) {
			super();
			this.r_num = r_num;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.num-o.num;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp != 0) {
				pq.offer(new Node(temp,Math.abs(temp)));
			}else {
				if(!pq.isEmpty()) {
					sb.append(pq.poll().r_num).append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}
		}
		System.out.println(sb);		
	}
}