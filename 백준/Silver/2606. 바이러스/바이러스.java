import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,count=0;	
	static int[][] map;
	static boolean[] isVisit;	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());		
		
		map = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			StringTokenizer index = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(index.nextToken());
			int y = Integer.parseInt(index.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
			
		}
		
		isVisit = new boolean[n+1];
		Arrays.fill(isVisit, false);
		
		isVisit[1] = true;
		virus(1);
		
		System.out.println(count);
		
	}
	
	public static void virus(int loc) {
		for(int i=1;i<=n;i++) {
			if(map[loc][i] == 1 && isVisit[i] == false) {
				count++;
				isVisit[i] = true;
				virus(i);
			}
		}
	}
}