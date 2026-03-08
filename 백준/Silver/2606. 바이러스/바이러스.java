import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, count;
	static ArrayList<Integer>[] graph;
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
// < 1. 입력받기
		
		n = Integer.parseInt(br.readLine());  // n: 컴퓨터 수 (노드 수)
		m = Integer.parseInt(br.readLine());  // m: 연결 갯수 (간선 수)
		
		// graph 만들기
		graph = new ArrayList[n+1];  // (1~n 개의 배열을 생성, 배열 내부는 ArrayList<Integer> 로 이후 for문에서 초기화해야함
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		// graph 만들기 완료
		
		// 간선 입력받기
		for(int i = 0; i < m; i++) {  // 간선 수 만큼 해당 간선 입력받기
			st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프이므로 다음과 같이 입력함
			graph[first].add(second);
			graph[second].add(first);
		}
		// 1. 입력받기 완료 > 
		
		bfs(1);
		System.out.println(count);
	}
	
// < 2. 그래프 탐색 함수 (bfs)
	
	static void bfs(int x) {
		// 방문체크 위한 boolean[] 생성
		boolean[] visited = new boolean[n+1];
		
		// 2-1. 큐 만들고 x를 넣기
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);  //x 넣기
		visited[x] = true;  // 방문체크
		count = 0;  // x부터 넣었지만 1은 카운트 안함 0 부터 시작
		
		while(!q.isEmpty()) {

			
			int k = q.poll();
			
			for(int i = 0; i < graph[k].size(); i++) {
				
				int next = graph[k].get(i);
				// 방문안했으면 큐에넣고 count + 1
				if(!visited[next]) {
					count+=1;
					visited[next] = true;
					q.offer(next);
				}
				
			}
		}
		
		
	}

}
