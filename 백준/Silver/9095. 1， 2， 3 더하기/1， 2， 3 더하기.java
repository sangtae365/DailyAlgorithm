import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int num[] = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<N;i++) {
			if(num[i] == 1) {
				sb.append("1").append("\n");
				continue;
			}
			if(num[i] == 2) {
				sb.append("2").append("\n");
				continue;
			}
			if(num[i] == 3) {
				sb.append("4").append("\n");
				continue;
			}
			int D[] = new int[num[i]+1];
			D[1] = 1;
			D[2] = 2;
			D[3] = 4;
			for(int j=4;j<=num[i];j++) {
				D[j] = D[j-1]+D[j-2]+D[j-3];
			}
			sb.append(D[num[i]]).append("\n");
		}
		System.out.println(sb);
	}
}