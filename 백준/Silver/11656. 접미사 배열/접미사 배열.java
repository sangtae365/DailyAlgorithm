import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String arr[] = new String[s.length()];
		
		for(int i=0;i<s.length();i++) {
			arr[i] = s.substring(i);
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(String ss : arr) {
			sb.append(ss).append("\n");
		}
		System.out.println(sb);
	}
}