import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static char map[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static Queue<int []> waterQ, gosumQ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		waterQ = new LinkedList<>();
		gosumQ = new LinkedList<>();
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S')gosumQ.add(new int[] {i,j,0});
				else if(map[i][j] == '*')waterQ.add(new int[] {i,j});
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
	}
	public static void bfs() {
		while(!gosumQ.isEmpty()) {
			int len = waterQ.size();
			for(int t=0;t<len;t++) {
				int temp[] = waterQ.poll();
				int x = temp[0];
				int y = temp[1];
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny] == '.') {
						map[nx][ny] = '*';
						waterQ.add(new int[] {nx,ny});
					}
				}
			}
			
			len = gosumQ.size();
			for(int t=0;t<len;t++) {
				int g[] = gosumQ.poll();
				int x = g[0];
				int y = g[1];
				int w = g[2];
				
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx>=0 && nx<R && ny>=0 && ny<C) {
						if(map[nx][ny] == 'D') {
							ans = Math.min(ans, w+1);
							return;
						}else if(map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							gosumQ.add(new int[] {nx,ny,w+1});
						}
					}
				}
			}
		}
	}
}