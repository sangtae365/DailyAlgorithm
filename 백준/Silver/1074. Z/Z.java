import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt=0;
	public static void z(int size, int r, int c) {
		if(size == 1) {			
			return;
		}
		if(r<size/2 && c<size/2) {
			z(size/2,r,c);
		}else if(r<size/2 && c>=size/2) {
			cnt += size * size /4;
			z(size/2,r,c-size/2);
		}else if(r>=size/2 && c<size/2) {
			cnt += size * size / 2;
			z(size/2,r-size/2,c);
		}else {
			cnt += size * size / 4 *3;
			z(size/2,r-size/2,c-size/2);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);	
		
		z(size,R,C);
		System.out.println(cnt);
	}
}