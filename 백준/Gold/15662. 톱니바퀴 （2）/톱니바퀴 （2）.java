import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, wheel[][], isValid[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		wheel = new int[N][8];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				wheel[i][j] = s.charAt(j)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			isValid = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wheelNum = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			
			check(wheelNum, dir);
			rotate();
		}
		System.out.println(calc());
	}
	public static void check(int wheelNum, int dir) {
		isValid[wheelNum] = dir;
		// 좌우 저장
		int left = wheelNum - 1;
		int right = wheelNum + 1;
		// 왼쪽 가능한지 체크
		if(left >= 0 && isValid[left] == 0) {
			if(wheel[left][2] != wheel[wheelNum][6]) {
				check(left, dir * -1);
			}
		}
		// 오른쪽 가능한지 체크
		if(right < N && isValid[right] == 0) {
			if(wheel[right][6] != wheel[wheelNum][2]) {	
				check(right, dir * -1);
			}
		}
	}
	public static void rotate() {
		for(int i=0;i<N;i++) {
			if(isValid[i] != 0) {
				int idx = 0;
				int temp[] = new int[8];
				
				for(int j=0;j<8;j++) {
					idx = j+isValid[i];
					if(idx == 8)idx = 0;
					else if(idx == -1)idx = 7;
					temp[idx] = wheel[i][j];
				}
				wheel[i] = temp;
			}
		}
	}
	public static int calc() {
		int sum = 0;
		for(int i=0;i<N;i++) {
			if(wheel[i][0] == 1)sum++;
		}
		return sum;
	}
}