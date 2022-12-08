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
		int num[] = new int[20000001];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			num[arr[i]+10000000]++;
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(binarySearch(arr, N, temp)) {
				sb.append(num[temp+10000000]).append(" ");
			}else {
				sb.append("0").append(" ");
			}
		}
		System.out.println(sb);
	}
	public static boolean binarySearch(int arr[], int N, int key) {		
		int start = 0;
		int end = N-1;
		
		while(start<=end) {
			int mid = (start + end)/2;
			if(arr[mid] == key) {
				return true;
			}else if(arr[mid]<key) {
				start = mid+1;
			}else if(arr[mid]>key) {
				end = mid-1;
			}
		}
		return false;
	}
}