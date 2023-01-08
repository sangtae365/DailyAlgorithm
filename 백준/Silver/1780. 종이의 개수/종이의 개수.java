import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int z_cnt, o_cnt, m_cnt;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		exp(0,0,N);
		System.out.println(m_cnt);
		System.out.println(z_cnt);
		System.out.println(o_cnt);
	}
	public static void exp(int x, int y, int N) {			
		if(N<1)return;
		// true면 다른 수가 있다
		boolean flag = false;
		int temp = map[x][y];
		
		for(int i=x,size = x+N;i<size;i++) {
			if(flag)break;
			for(int j=y,size2 = y+N;j<size2;j++) {
				if(flag)break;
				if(map[i][j] != temp)flag = true;
			}
		}
		
		if(!flag && temp == 0)z_cnt++;
		else if(!flag && temp == 1)o_cnt++;
		else if(!flag && temp == -1)m_cnt++;
		if(!flag)return;
		
		int length = N/3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				exp(x+i*length,y+j*length,length);
			}
		}
	}
}