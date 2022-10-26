

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Box{
        int num;
        int dist;
        int count;

        public Box(int num, int dist, int count) {
            this.num = num;
            this.dist = dist;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list[] = new ArrayList[N+1];
        
        for(int i=0; i<N+1; i++) {
        	list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            list[A].add(B);
            list[B].add(A);
        }
        boolean [] visit = new boolean[N+1];


        int num =0,dist =0, count=0;

        Queue<Box> queue = new LinkedList<Box>();
        visit[1] = true;
        queue.offer(new Box(1, 0, 1));

        while(!queue.isEmpty()){
            Box temp = queue.poll();


            for (int i = 0; i < list[temp.num].size(); i++) {
            	int next = list[temp.num].get(i);

                if(visit[next]) continue;
                visit[next] = true;
                
                if(dist<temp.dist+1){
                    num = next;
                    dist = temp.dist+1;
                    count = 1;
                } else{
                	num = Math.min(num, next);
                    count++;
                }

                queue.offer(new Box(next, dist, count));
            }
        }

        System.out.println(num+" "+dist+" "+count);

    }
}
