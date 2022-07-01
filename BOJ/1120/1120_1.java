/**
* 메모리: 14236 KB, 시간: 124 ms
* 2022.07.02
* by Alub
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken(); //길이 더 적음
		String B = st.nextToken();
	
		int min = 50; 	//최소차이
		
		for (int i = 0; i <= B.length()-A.length(); i++) {	//B시작부분
			int temp = 0;
			for (int j = 0; j < A.length(); j++) {
				if(B.charAt(i+j) != A.charAt(j)) temp++;
			}
			min = Math.min(min, temp);
		}
		System.out.println(min);
    }

}
