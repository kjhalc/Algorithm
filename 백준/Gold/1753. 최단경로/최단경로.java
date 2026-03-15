import java.util.*;
import java.io.*;

public class Main {
	static StringTokenizer st;
	static int v, e, k;
	static ArrayList<int[]>[] graph;  // 안에 (to, weight) 들어감 
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// v, e 입력
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[v+1];
		visited = new boolean[v+1];
		result = new int[v+1];
		
		// graph 초기화
		for(int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// k 입력
		k = Integer.parseInt(br.readLine());
		
		// e 만큼 돌면서 그래프 입력받기
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int third = Integer.parseInt(st.nextToken());
			
			graph[first].add(new int[] {second, third});
//			graph[second].add(new int[] {first, third});	방향그래프인지 무방향그래프인지 확인하기
		}
		
		//// 여기까지 그래프 입력받기 완료
		
		for(int i = 1; i <= v; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		
		//// 여기서부터 step1 선택 step2 업데이트 반복
		
		
		result[k] = 0;
		int count = 0;
		
		
		// 우선순위 큐 로직 시작
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
		
		pq.offer(new int[] {k, 0});
		visited[k] = true;
		result[k] = 0;
		
		while(!pq.isEmpty()) {
			
			
			int[] next = pq.poll();
			if(next[1] > result[next[0]]) continue;
			
			// next와 연결된 것들의 result 업데이트
			for(int p = 0; p < graph[next[0]].size(); p++) {
				int[] nnt = graph[next[0]].get(p);
				if(!visited[nnt[0]] && result[nnt[0]] > result[next[0]]+nnt[1]) {
					result[nnt[0]] = result[next[0]]+nnt[1];
					pq.offer(new int[] {nnt[0], result[nnt[0]]});
				}
			
			}
			
		}

		
		
		
		// 결과 출력
		for(int p = 1; p <= v; p++) {
			if(result[p]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(result[p]);
			}
			
		}
		
	}
	
}
