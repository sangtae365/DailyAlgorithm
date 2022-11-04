import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int tower[] = new int[N];
		for(int i=0;i<N;i++) {
			tower[i] = Integer.parseInt(br.readLine());
		}
		
		long sum = 0;
		s.add(tower[0]);
		for(int i=1;i<N;i++) {
			if(s.peek()>tower[i]) {
				s.add(tower[i]);
			}else {
				while(!s.isEmpty()) {
					if(s.peek()<=tower[i]) {
						s.pop();
						sum+=s.size();
					}
					else break;
				}
				s.add(tower[i]);
			}
		}
		while(!s.isEmpty()) {
			s.pop();
			sum+=s.size();
		}
		System.out.println(sum);
	}
}