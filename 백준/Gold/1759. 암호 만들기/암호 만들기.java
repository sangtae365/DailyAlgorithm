import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C;
	static char alpha[], temp[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		temp = new char[L];
		String s = br.readLine().replace(" ", "");
		for(int i=0;i<C;i++) {
			alpha[i] = s.charAt(i);
		}
		Arrays.sort(alpha);
		
		comb(0,0);
		System.out.println(sb);
	}
	public static void comb(int cnt, int start) {
		if(cnt == L) {
			String s = "";
			int vowel = 0;
			int consonants = 0;
			for(int i=0;i<L;i++) {
				if(temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
					vowel++;
				}else {
					consonants++;
				}
				s += temp[i];
			}
			if(vowel < 1 || consonants < 2)return;
			sb.append(s+"\n");
			return;
		}
		
		for(int i=start;i<C;i++) {
			temp[cnt] = alpha[i];
			comb(cnt+1, i+1);
		}
	}
}