import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
		}
		int D[] = new int[N];
		D[0] = num[0];
		for(int i=1;i<N;i++) {
			D[i] = num[i]+D[i-1];
		}
		
		for(int i=0;i<M;i++) {
			int ans = 0;
			int arr[] = list.get(i);
			if(arr[0] == 0) {
				sb.append(D[arr[1]]).append("\n");
				continue;
			}
			ans = D[arr[1]]-D[arr[0]-1];
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}