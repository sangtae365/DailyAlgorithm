import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> plus_pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus_pq = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(temp<0)minus_pq.add(Math.abs(temp));
			else plus_pq.add(temp);
		}
		int max = 0;
		if(!plus_pq.isEmpty() && !minus_pq.isEmpty()) {
			max = Math.max(plus_pq.peek(), minus_pq.peek());
		}else {
			if(plus_pq.isEmpty())max = minus_pq.peek();
			else max = plus_pq.peek();
		}
		
		int ans = 0;
		
		while(plus_pq.size()>M) {
			ans += plus_pq.peek() * 2;
			for(int i=0;i<M;i++) {
				plus_pq.poll();
			}
		}
		if(!plus_pq.isEmpty())ans += plus_pq.peek()*2;
		while(minus_pq.size()>M) {
			ans += minus_pq.peek() * 2;
			for(int i=0;i<M;i++) {
				minus_pq.poll();
			}
		}
		if(!minus_pq.isEmpty())ans += minus_pq.peek() * 2;
		
		System.out.println(ans-max);
	}
}