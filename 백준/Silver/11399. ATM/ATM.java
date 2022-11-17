import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] need = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			need[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(need);
		int cnt = N;
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += need[i] * cnt--; 
		}
		
		System.out.println(sum);
	}

}
