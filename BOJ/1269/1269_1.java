/**
* 메모리: 79640 KB, 시간: 756 ms
* 2022.07.06
* by Alub
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Asize = Integer.parseInt(st.nextToken());
		int Bsize = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> setA= new HashSet<>();
		HashSet<Integer> setB= new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Asize; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Bsize; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		
		int answer = setA.size()+setB.size();
		
		for(Integer c : setB) {
			if(setA.contains(c)) answer-=2;
		}
		
		System.out.println(answer);
	}

}
