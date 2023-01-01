import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int score[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int D[] = new int[N+1];
		D[1] = score[1];
		if(N>=2)D[2] = score[1]+score[2];
		for(int i=3;i<=N;i++) {			
			D[i] = Math.max(D[i-3]+score[i-1], D[i-2]) + score[i];
		}
		System.out.println(D[N]);
	}
}