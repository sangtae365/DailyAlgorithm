import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println("1");
			return;
		}
		if(N==2) {
			System.out.println("3");
			return;
		}
		int[] square = new int[N+1];
		square[1] = 1;
		square[2] = 3;
		
		for(int i=3;i<=N;i++) {
			square[i] = (square[i-1] + 2*square[i-2])%10007;
		}
		System.out.println(square[N]);
	}
}
