/**
* 메모리: 14256 KB, 시간: 124 ms
* 2022.07.02
* by Alub
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int cur = str.charAt(i)-'0';
			//9랑 6을 다 6으로
			if(cur==9) cur=6;
			
			if(map.containsKey(cur)) {
				map.replace(cur, map.get(cur)+1);
				if(cur==6) {
					max = Math.max(max, (map.get(cur)+1)/2);
				} else {
					max = Math.max(max, map.get(cur));
				}
			} else {
				map.put(cur, 1);
				max = Math.max(max, 1);
			}
		}
		System.out.println(max);
	
    }

}
