import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger N = new BigInteger(br.readLine());
		BigInteger start = new BigInteger("1");
		BigInteger end = N;
		BigInteger mid;
		
		while(true) {
			mid = start.add(end);
			mid = mid.divide(new BigInteger("2"));
			
			int result = (mid.multiply(mid)).compareTo(N);
			if(result == 0)break;
			else if(result == 1)end = mid.subtract(new BigInteger("1"));
			else start = mid.add(new BigInteger("1"));
			
		}
		System.out.println(mid.toString());
	}
}