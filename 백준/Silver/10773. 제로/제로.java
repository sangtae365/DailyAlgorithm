import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp != 0) {
				s.push(temp);
			}else {
				if(!s.isEmpty()) {
					s.pop();
				}
			}
		}
		int sum = 0;
		while(!s.isEmpty()) {
			sum+=s.pop();
		}
		System.out.println(sum);
	}
}