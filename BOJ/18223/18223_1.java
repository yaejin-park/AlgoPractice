/**
* 메모리: 22100 KB, 시간: 312 ms
* 2022.07.16
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());	//정점
		int E = Integer.parseInt(st.nextToken());	//간선
		int P = Integer.parseInt(st.nextToken());	//건우 위치
		
		list = new ArrayList[V+1];
		
		for (int i = 0; i < V+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		int a = dijkstra(1, V, V);
		int b = dijkstra(1, P, V) + dijkstra(P, V, V) ;
		
		
		if(a==b) {
			System.out.println("SAVE HIM");
		} else {
			System.out.println("GOOD BYE");
		}
	}
	
	static int dijkstra(int start, int end, int V) {
		int dist[] = new int[V+1];
		Arrays.fill(dist,987654321);
		
		boolean checked[] = new boolean[V+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		
		while(!pq.isEmpty()) {
			Node cur= pq.poll();
//			System.out.println(cur.end);
			if(checked[cur.end]) continue;
			checked[cur.end] = true;
			if(cur.end == end) break;
			
			for (Node next : list[cur.end]) {
				if(!checked[next.end] &&dist[next.end] > dist[cur.end] + next.weight) {
					dist[next.end] = dist[cur.end] + next.weight;
					pq.offer(next);
				}
			}
		}
		return dist[end];
	}
}
