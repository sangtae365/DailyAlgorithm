import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		if(next_permutation(num)) {
			for(int temp : num) {
				sb.append(temp+" ");
			}
		}else {
			sb.append("-1");
		}
		System.out.println(sb);
	}

	private static boolean next_permutation(int[] num) {
		int i = num.length-1;
		// num[i-1] < num[i] 를 만족하는 가장 큰 i 찾기
		while(i>0 && num[i-1] > num[i]) {
			i-=1;
		}
		
		if(i<=0)return false;
		
		int j = num.length-1;
		
		// j>=i 이면서 num[j] > num[i-1]을 만족하는 가장 큰 j 찾기
		while(num[i-1] >= num[j]) {
			j -= 1;
		}
		
		int temp = num[i-1];
		num[i-1] = num[j];
		num[j] = temp;
		
		j = num.length-1;
		
		while(i<j) {
			temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i+=1;
			j-=1;
		}
		return true;		
	}
}