import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		int limit = Integer.parseInt(br.readLine());
		if(sum<=limit) {
			System.out.println(arr[N-1]);
			return;
		}
		int start = 0;
		int end = arr[N-1];
		int mid = 0;
		while(start<=end) {
			mid = (start+end)/2;
			int total = 0;
			for(int i=0;i<N;i++) {
				if(arr[i]<mid)total+=arr[i];
				else total+=mid;
			}
			
			if(total<=limit)start = mid+1;
			else end = mid-1;
		}
		
		System.out.println(end);
	}
}