import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		TreeMap<String, Integer> list[] = new TreeMap[N];
		String group[] = new String[N];
		for(int i=0;i<N;i++) {
			list[i] = new TreeMap<>();
		}
		for(int i=0;i<N;i++) {
			group[i] = br.readLine();
			int num = Integer.parseInt(br.readLine());
			
			for(int j=0;j<num;j++) {
				list[i].put(br.readLine(), j);
			}
		}
		
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				// 해당 팀 전원을 사전순으로 출력
				for(int j=0;j<N;j++) {
					if(group[j].equals(temp)) {
						for(String s : list[j].keySet()) {
							sb.append(s).append("\n");
						}						
						break;
					}
				}
				
			}else {
				for(int j=0;j<N;j++) {
					if(list[j].containsKey(temp)) {
						sb.append(group[j]).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
