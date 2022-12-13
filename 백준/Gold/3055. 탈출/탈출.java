import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<int []> water_q, gosum_q;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int R,C,ans;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		water_q = new LinkedList<>();
		gosum_q = new LinkedList<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					gosum_q.add(new int[] {i,j,0});
				}else if(map[i][j] == '*') {
					water_q.add(new int[] {i,j});
				}
			}
		}
		ans = Integer.MAX_VALUE;
		
		bfs();
		
		System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
	}

	private static void bfs() {
		while(!gosum_q.isEmpty()) {
			int len = water_q.size();
			for(int i=0;i<len;i++) {
				int temp[] = water_q.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int j=0;j<4;j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C)continue;
					if(map[nx][ny] == '.') {
						map[nx][ny] = '*';
						water_q.add(new int[] {nx,ny});
					}
				}
			}
			len = gosum_q.size();
			for(int i=0;i<len;i++) {
				int temp[] = gosum_q.poll();
				int x = temp[0];
				int y = temp[1];
				int time = temp[2];
				
				for(int j=0;j<4;j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C)continue;
					if(map[nx][ny] == '.') {
						gosum_q.add(new int[] {nx,ny,time+1});
						map[nx][ny] = 'S';
					}else if(map[nx][ny] == 'D') {
						ans = Math.min(ans, time+1);
						return;
					}
				}
			}
		}
	}
}