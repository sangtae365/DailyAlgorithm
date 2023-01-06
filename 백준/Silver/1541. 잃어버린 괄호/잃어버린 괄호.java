import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String temp = "";
		boolean flag = false;
		
		int sum = 0;
		int extra = 0;
		for(int i=0;i<str.length();i++) {			
			if(str.charAt(i) == '-') {
				if(!flag) {
					flag = true;
					sum += Integer.parseInt(temp);
					temp = "";
				}else {
					extra += Integer.parseInt(temp);
					sum -= extra;
					extra = 0;
					temp = "";
				}				
			}else if(str.charAt(i) == '+') {
				if(flag) {
					extra+=Integer.parseInt(temp);
					temp = "";
				}else {
					sum+=Integer.parseInt(temp);
					temp = "";
				}
			}else {
				temp+=str.charAt(i);
			}
		}
		if(flag) {
			extra += Integer.parseInt(temp);
		}else {
			sum += Integer.parseInt(temp);
		}
		sum -= extra;
		System.out.println(sum);
	}
}