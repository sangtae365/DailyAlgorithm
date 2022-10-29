import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int to,w;

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[N+1];
		int[] dist = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean visited[] = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int now = temp.to;
			if(visited[now])continue;
			visited[now] = true;
			
			for(Node node : list[now]) {
				int next = node.to;
				int w = node.w;
				if(!visited[next] && dist[next]>dist[now]+w) {
					dist[next] = dist[now] + w;
					pq.offer(new Node(next, dist[next]));
				}
			}
		}
		System.out.println(dist[end]);
	}
}