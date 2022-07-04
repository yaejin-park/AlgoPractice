/**
* 메모리: 15004 KB, 시간: 156 ms
* 2022.07.05
* by Alub
*/

import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int S[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(str);
			
			k = Integer.parseInt(st.nextToken());
			visited = new boolean[k];
			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			permu(new int[6], 0, 0);
			
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);
	}
    

	private static void permu(int[] arr, int cnt, int start) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(System.lineSeparator());
			return;
		}
		
		for (int i = start; i < k; i++) {
			arr[cnt] = S[i];
			permu(arr, cnt+1, i+1);
		}
	}

}
