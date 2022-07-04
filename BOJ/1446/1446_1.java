/**
* 메모리: 14212 KB, 시간: 132 ms
* 2022.07.05
* by Alub
*/

import java.io.*;
import java.util.*;

public class Main {
	static Edge[] Rode;
	static int N, D, distance[], INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int len;
		
		public Edge(int start, int end, int len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return this.len - o.len;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());	//지름길의 개수
        D = Integer.parseInt(st.nextToken());	//고속도로의 길이(<10000)
        
        Rode = new Edge[N];
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			Rode[i] = new Edge(start, end, len);
		}
        
        
        PriorityQueue<Edge> pq = new PriorityQueue();
        distance = new int[D+1];
        for(int i=0; i<D+1; i++) {
        	distance[i] = i;
        }
        
        pq.offer(new Edge(0, 0, 0));
        
        while(!pq.isEmpty()) {
        	Edge cur = pq.poll();
        	
        	for(Edge next : Rode) {
        		if(next.start >= cur.end) {
	        		if(cur.end >= next.end || next.end > D) continue;
	        		
	        		int tmp = next.start - cur.end;
	        		if(distance[next.end] > distance[cur.end] + next.len + tmp) {
	        			distance[next.end] = distance[cur.end] + next.len + tmp;
	        			pq.offer(new Edge(cur.end, next.end, distance[next.end]));
	        		}
        		}
        	}
        	distance[D] = Math.min(distance[cur.end]+D-cur.end, distance[D]);
        }
        
        System.out.println(distance[D]);
    }
	
}
