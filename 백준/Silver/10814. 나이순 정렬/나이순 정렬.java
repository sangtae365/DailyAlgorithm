import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class P implements Comparable<P>{
		int num, age;
		String name;
		
		public P(int num, int age, String name) {
			super();
			this.num = num;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(P o) {
			return this.age != o.age?this.age-o.age:this.num-o.num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		P p[] = new P[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new P(i,Integer.parseInt(st.nextToken()),st.nextToken());
		}
		Arrays.sort(p);
		
		for(P pe : p) {
			sb.append(pe.age).append(" ").append(pe.name).append("\n");
		}
		System.out.println(sb);
	}
}
