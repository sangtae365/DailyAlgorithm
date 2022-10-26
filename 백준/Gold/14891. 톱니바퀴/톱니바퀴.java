import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int chain[][], isValid[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		chain = new int[4][8];
		
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				chain[i][j] = s.charAt(j)-'0';
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			isValid = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int chainNum = Integer.parseInt(st.nextToken()) - 1;
			int way = Integer.parseInt(st.nextToken());
			
			check(chainNum, way);
			spin();
		}
		
		System.out.println(calc());
	}
	public static void check(int chainNum, int way) {
		// 톱니바퀴 방향 저장
		isValid[chainNum] = way;
		
		int left = chainNum - 1;
		int right = chainNum + 1;
		
		// 왼쪽이 있고 회전이 없다면
		if(left >= 0 && isValid[left] == 0) {
			// 왼쪽 검사
			if(chain[left][2] != chain[chainNum][6]) {
				check(left, way * -1);
			}
		}
		// 오른쪽이 있고 회전이 없다면
		if(right <= 3 && isValid[right] == 0) {
			// 오른쪽 검사
			if(chain[right][6] != chain[chainNum][2]) {
				check(right, way * -1);
			}
		}
	}
	// 톱니바퀴 회전시키기
	public static void spin() {
		for(int i=0;i<4;i++) {
			if(isValid[i] != 0) {
				int temp[] = new int[8];
				
				int idx;
				for(int j=0;j<8;j++) {
					idx = j+isValid[i];
					
					if(idx == -1) idx = 7;
					else if(idx == 8) idx = 0;
					
					temp[idx] = chain[i][j];
				}
				
				chain[i] = temp;
			}
		}
	}
	static int calc() {
		int sum = 0;
		for(int i=0;i<4;i++) {
			int num = chain[i][0];
			if(num == 1) {
				sum += Math.pow(2, i);
			}
		}
		return sum;
	}
}