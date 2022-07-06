/**
* 메모리: 227036 KB, 시간: 780 ms
* 2022.07.06
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		HashSet<String> set = new HashSet<>();
		//시작부분
		for (int i = 0; i < str.length(); i++) {
			//길이
			for (int j = 1; j <= str.length()-i; j++) {
				set.add(str.substring(i, i+j));
			}
		}
		System.out.println(set.size());
	}

}
