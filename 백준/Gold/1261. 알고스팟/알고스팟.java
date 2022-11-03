import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	
	//상하좌우
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		//뚫은 개수 오름차순
		@Override
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());	//가로
		N = Integer.parseInt(st.nextToken());	//세로
		
		map = new int [N][M];
		visited = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		
		bfs(0,0);
	}

	private static void bfs(int r, int c) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(r, c, 0));
		visited[r][c] = true;
		
		while(true) {
			Point cur = pq.poll();
			
			//도착하면
			if(cur.r == N-1 && cur.c== M-1) {
				System.out.println(cur.cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				//경계검사
				if(nr < 0 || nc < 0 || nr>= N || nc >= M) continue;
				
				//방문체크
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;

				if(map[nr][nc] == 0) {
					pq.offer(new Point(nr, nc, cur.cnt));
				} else {
					pq.offer(new Point(nr, nc, cur.cnt+1));
				}
			}
		}
	}
}
