/**
* 메모리: 17452 KB, 시간: 192 ms
* 2022.07.01
* by Alub
*/

import java.io.*;
import java.util.*;
 
public class Main {
	static int parents[];
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());	//도시의 수(200이하)
        int M = Integer.parseInt(br.readLine());	//여행계획 속한 도시 수(1000이하)
        
        parents = new int[N+1];
        
        for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
        
        for (int i = 1; i < N+1; i++) {	//i번도시와
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 1; j < N+1; j++) {//j번 도시
        		int link = Integer.parseInt(st.nextToken());	//연결이면 1, 아니면 0
        		
        		if(link == 1) {
        			union(i,j);
        		} 
			}
		}
        
        String answer = "YES";
        
        StringTokenizer st = new StringTokenizer(br.readLine());	//여행계획
        int a = parents[Integer.parseInt(st.nextToken())];
        
        for (int i = 1; i < M; i++) {
			int b = Integer.parseInt(st.nextToken());
			if(a!=parents[b]) {
				answer = "NO";   
				break;
			}
		}
        System.out.println(answer);
    }
    
    private static int findSet(int a) {
		if(parents[a] ==a) return a;
		return parents[a] = findSet(parents[a]);
	}
    

	private static void union(int a, int b) {
		int A = findSet(a);
		int B = findSet(b);
		
		if(A==B) return;
		
		if(A < B) {
			parents[B] = A;
		} else {
			parents[A] = B;
		}
	}
}
