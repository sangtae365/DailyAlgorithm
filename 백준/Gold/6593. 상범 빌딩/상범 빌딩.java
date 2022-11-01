import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L,R,C;
	static char map[][][];
	static int dx[] = {0,1,0,-1,0,0};
	static int dy[] = {1,0,-1,0,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	static boolean visited[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0)break;
			
			map = new char[R][C][L];
			visited = new boolean[R][C][L];
			
			String str;
			int sx = 0, sy = 0, sz = 0;
			for(int k=0;k<L;k++) {
				for(int i=0;i<R;i++) {
					str = br.readLine();
					for(int j=0;j<C;j++) {
						map[i][j][k] = str.charAt(j);
						if(map[i][j][k] == 'S') {
							sx = i;
							sy = j;
							sz = k;
						}
					}
				}
				str = br.readLine();
			}
			int ans = bfs(sx,sy,sz);
			if(ans==-1) {
				sb.append("Trapped!").append("\n");
			}else {
				sb.append("Escaped in ").append(ans).append(" minute(s).").append("\n");
			}
		}
		System.out.println(sb);
	}
	private static int bfs(int sx, int sy, int sz) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {sx,sy,sz,0});
		visited[sx][sy][sz] = true;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int z = temp[2];
			int cnt = temp[3];
			
			if(map[x][y][z] == 'E') {
				return cnt;
			}
			
			for(int i=0;i<6;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				
				if(isAvailable(nx, ny, nz)) {
					queue.offer(new int[] {nx,ny,nz,cnt+1});
					visited[nx][ny][nz] = true;
				}
			}
		}
		return -1;		
	}
	public static boolean isAvailable(int x, int y, int z) {
		if(x<0 || x>=R || y<0 || y>=C || z<0 || z>=L || visited[x][y][z] || map[x][y][z] == '#')return false;
		return true;
	}
}