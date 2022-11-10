import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long line[] = new long[K];
		for(int i=0;i<K;i++) {
			line[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(line);
		long start = 0;
		long end = line[K-1]+1;
		long mid = 0;
		
		while(start<end) {
			mid = (start+end)/2;
			long cnt = 0;
			for(int i=0;i<K;i++) {
				cnt += line[i]/mid;
			}
			
			if(cnt>=N) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		System.out.println(end-1);
	}
}