import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Main 클래스에서 Solution클래스 선언해주기
public class Main {
    public static void main(String[] ars) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());

            //나를 볼 수 있는 사람(나보다 큰)
            while(!stack.isEmpty() && stack.peek()<=h){
                stack.pop();
            }
            answer+= stack.size();
            stack.push(h);
        }

        System.out.println(answer);
    }
}