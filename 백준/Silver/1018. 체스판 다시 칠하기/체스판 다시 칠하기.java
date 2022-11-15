import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();			
			map[i] = str.toCharArray();
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp = search(map,i,j);
				if(temp != -1) {
					min = Math.min(min, temp);
				}
			}
		}
		System.out.println(min);
	}
	public static int search(char map[][], int x, int y) {
		if(x+8>N || y+8>M)return -1;
		char temp = map[x][y];
		int cnt = 0;
		// W 일때 true
		boolean flag = true;
		if(temp == 'B')flag = false;
		
		for(int i=x,size = x+8;i<size;i++) {			
			for(int j=y,size2=y+8;j<size2;j++) {
				if(flag && map[i][j] == 'B')cnt++;
				if(!flag && map[i][j] == 'W')cnt++;
				flag = !flag;
			}
			flag = !flag;
		}
		cnt = Math.min(cnt, 64-cnt);
		return cnt;
	}
}