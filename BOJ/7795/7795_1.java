/**
* 메모리: 38884 KB, 시간: 540 ms
* 2022.07.16
* by Alub
*/

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String sA[] = br.readLine().split(" ");
			int A[] = Arrays.stream(sA).mapToInt(Integer::parseInt).toArray();
			
			String sB[] = br.readLine().split(" ");
			int B[] = Arrays.stream(sB).mapToInt(Integer::parseInt).toArray();
		
			Arrays.sort(A);
			Arrays.sort(B);
			
			
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				int a = A[j];
				
				int start = 0;
				int end = M;
				
				int max = 0;
				
				//이분탐색
				while(start<=end) {
					int mid = (start+end)/2;
					if(mid >=M) break;
					int b = B[mid];
					if(a <= b) {
						end = mid-1;
					} else if(a > b) {
						max = Math.max(max, mid+1);
						start = mid+1;
					}
				}
				cnt+= max;
			}
			System.out.println(cnt);
		}
	}
}
