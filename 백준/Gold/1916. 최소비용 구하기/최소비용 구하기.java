import java.util.*;
import java.io.*;

public class Main {
	static StringTokenizer st;
	static int n, m;
	static ArrayList<int[]>[] graph;
	static boolean[] visited;
	static int[] dist;
	static int start, end;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int third = Integer.parseInt(st.nextToken());
			
			graph[first].add(new int[] {second, third});
//			graph[second].add(new int[] {first, third});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		// 입력완료
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		
		pq.offer(new int[] {start, 0});  // 시작 점 넣기
		
		visited[start] = true;  //방문체크
		dist[start] = 0;

		
		while(!pq.isEmpty()) {
			
			int[] next = pq.poll();
			if(next[1] > dist[next[0]]) continue;
			

			int n_to = next[0];
			int n_dist = next[1];
			visited[n_to] = true;

			
			//step2
			for(int i = 0; i < graph[n_to].size(); i++) {
				int[] option = graph[n_to].get(i);  // option 은 {다음연결위치, 가중치} 꼴
				
				if(!visited[option[0]] && dist[option[0]] > dist[n_to] + option[1]) {
					dist[option[0]] = dist[n_to] + option[1];  // 방문하지 않았고 거리 이득이 있다면 해당 값 업데이트 (방문이 아님)
					pq.offer(new int[] {option[0], dist[option[0]]});
				}
				
			}

			
		}
		
		System.out.println(dist[end]);
		
		
		
		
		

	}

}
