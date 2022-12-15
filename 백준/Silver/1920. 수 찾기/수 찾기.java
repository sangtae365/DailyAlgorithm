import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬을 시켜준다
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		int check[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			check[i] = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(arr, N, check[i])).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int arr[], int N, int key) {
		int start = 0;
		int end = N-1;
				
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid] == key) {
				return 1;
			}else if(arr[mid]<key) {
				start = mid+1;
			}else if(arr[mid]>key) {
				end = mid-1;
			}
		}
		return 0;
	}
}
