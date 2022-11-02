import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int to, w;

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
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[V+1];
		int dist[] = new int[V+1];
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,w));
		}
		
		boolean visited[] = new boolean[V+1];
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			int now = temp.to;
			if(visited[now])continue;
			visited[now] = true;
			
			for(Node node : list[now]) {
				int next = node.to;
				int w = node.w;
				if(!visited[next] && dist[next] > dist[now]+w) {
					dist[next] = dist[now]+w;
					pq.offer(new Node(next,dist[next]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(dist[i] == Integer.MAX_VALUE)sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}