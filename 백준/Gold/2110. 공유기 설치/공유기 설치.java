import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int house[] = new int[N];
		for(int i=0;i<N;i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int start = 1;
		int end = house[N-1]-house[0]+1;
		
		while(start<end) {
			int mid = (start+end)/2;
			int sum = 0;
			int cnt = 1;
			for(int i=0;i<N-1;i++) {
				int dif = house[i+1] - house[i];
				sum+=dif;
				if(sum>=mid) {
					cnt++;
					sum = 0;
				}
			}
			if(cnt>=C) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		System.out.println(end-1);
	}
}