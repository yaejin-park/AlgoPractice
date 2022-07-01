/**
* 메모리: 131460 KB, 시간: 644 ms
* 2022.07.02
* by Alub
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	//위 아래 왼쪽 오른쪽 앞 뒤
	static int[]df = {-1,1,0,0,0,0};
	static int[]dr = {0,0,0,0,-1,1};
	static int[]dc = {0,0,-1,1,0,0};
	
	static class Edge{
		int f;
		int r;
		int c;
		int time;
		
		public Edge(int f, int r, int c, int time) {
			super();
			this.f = f;
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int M,N,H;
	static int box[][][];
	static boolean visited[][][];
	    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());	//가로칸수
		N = Integer.parseInt(st.nextToken());	//세로칸수
		H = Integer.parseInt(st.nextToken());	//상자수
		
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		int cnt = 0;	//익지않은 토마토
		Queue<Edge> que = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int cur = Integer.parseInt(st.nextToken());
					box[i][j][k]= cur;
					if(cur == 1 ) {
						que.offer(new Edge(i, j, k, 0));
					} else if(cur == 0) {
						 cnt++;
					}
				}
			}
		}
		
		int time = 0;
		
		//H(상자수),N(세로칸수),M(가로칸수)
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			
			for (int i = 0; i < 6; i++) {
				int nf = cur.f + df[i];
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nf < 0 || nf>=H || nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(visited[nf][nr][nc] || box[nf][nr][nc] != 0) continue;
				
				visited[nf][nr][nc] = true;
				box[nf][nr][nc] = 1;
				que.offer(new Edge(nf, nr, nc, cur.time+1));
				cnt--;
				if(cnt==0) {
					time = cur.time+1;
					break;
				}
			}
		}
		
		
		System.out.println(cnt==0?time:"-1");
    }

}
