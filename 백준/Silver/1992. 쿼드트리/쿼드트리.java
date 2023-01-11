import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// Main_S1_1992_박상태
	
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void tree(int x, int y, int size) {
		if(isCompress(x,y,size)) {
			sb.append(map[x][y]);
			return;
		}
		
		int len = size/2;
		
		sb.append("(");
		
		tree(x,y,len);			// 왼쪽 위
		tree(x,y+len,len);		// 오른쪽 위
		tree(x+len,y,len);		// 왼쪽 아래
		tree(x+len,y+len,len);	// 오른쪽 아래
		
		sb.append(")");
		
	}
	
	public static boolean isCompress(int x, int y, int size) {
		int num = map[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(map[i][j] != num)return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}		
		
		tree(0,0,N);
		
		System.out.println(sb);
	}	
}
