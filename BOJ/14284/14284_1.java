/**
* 메모리: 47700 KB, 시간: 412 ms
* 2022.07.05
* by Alub
*/

import java.io.*;
import java.util.*;

public class Main {
	
	static class Vertex implements Comparable<Vertex>{
		int a;
		int weight;
		
		public Vertex(int a, int weight){
			this.a = a;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight-o.weight;
		}
	}
	
	    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//정점 개수
		int m = Integer.parseInt(st.nextToken());	//간선 개수
		
		ArrayList<Vertex>[] list = new ArrayList[n+1];
		
		for (int i = 1; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			//a와 b가 연결될 때 c
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Vertex(b, c));
			list[b].add(new Vertex(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		
		//연결되어야 하는 
		int s = Integer.parseInt(st.nextToken());	
		int t = Integer.parseInt(st.nextToken());	

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		boolean check[] = new boolean[n+1];
		int dist[] = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		check[s] = true;
		pq.offer(new Vertex(s, 0));
 		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if(cur.a == t) break;
			
			for(Vertex next : list[cur.a]) {
				if(dist[next.a] > dist[cur.a] + next.weight ) {
					dist[next.a] = dist[cur.a] + next.weight;
					pq.offer(new Vertex(next.a, dist[next.a]));
				}
			}
		}
		System.out.println(dist[t]);
    }

}
