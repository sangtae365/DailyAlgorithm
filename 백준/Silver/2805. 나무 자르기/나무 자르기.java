import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int tree[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		
		int start = 0;
		int end = tree[N-1];
		
		while(start<end) {
			int mid = (start+end)/2;
			long sum = 0;
			for(int i=0;i<N;i++) {
				if(tree[i]>mid)sum+=(tree[i]-mid);
			}
			
			if(sum<M) {
				end = mid;
			}else {
				start = mid+1;
			}			
		}
		System.out.println(start-1);
	}	
}