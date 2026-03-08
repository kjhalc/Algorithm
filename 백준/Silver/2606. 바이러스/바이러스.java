import java.util.*;
import java.io.*;


public class Main {
	
	static StringTokenizer st;
	
	static int n, m;
	static ArrayList<Integer>[] graph;
	
	static boolean[] visited;
	static int count;
	
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		// 그래프 만들기
		graph = new ArrayList[n+1];
		for(int i = 1; i <= n; i++ ) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			graph[first].add(second);
			graph[second].add(first);
		}
		
		
		// 입력 완료
		
		//
		visited = new boolean[n+1];
		
		visited[1] = true;
		count = 0;
		dfs(1);
		
		
		System.out.println(count);
		
	}
	
	// dfs 만들기
	
	static void dfs(int x) {
		
		
		for(int next : graph[x]) {

			if(visited[next] == false) {
				
				visited[next] = true;
				count++;
				dfs(next);
			}
		}
		
		return;
		
	}

}
