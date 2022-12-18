import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hash = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int num = 1;
		for(int i=0,size=N+M;i<size;i++) {
			String str = br.readLine();
			hash.add(str);		
			if(hash.size() != num) {
				list.add(str);
				cnt++;
				num--;
			}
			num++;
		}
		Collections.sort(list);
		
		System.out.println(cnt);		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
