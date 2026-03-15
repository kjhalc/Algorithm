import java.util.*;
import java.io.*;

public class Solution {
	static StringTokenizer st;
	static int v, e;
	static ArrayList<int[]>[] graph;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			
			st = new StringTokenizer(br.readLine());
			
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[v+1];
			visited = new boolean[v+1];
			result = new int[v+1];
			
			for(int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				int third = Integer.parseInt(st.nextToken());
				
				graph[first].add(new int[] {second, third});
				graph[second].add(new int[] {first, third});
			}
			
			// 입력 완료
			
			for(int i = 1; i <= v; i++) {
				result[i] = Integer.MAX_VALUE;
			}
			
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			
			pq.offer(new int[] {1, 0});  // 정점 1부터 시작
			visited[1] = true;
			result[1] = 0;
			
			
			while(!pq.isEmpty()) {
				
				int[] next = pq.poll();
				if (next[1] > result[next[0]] ) continue;
				visited[next[0]] = true;
				result[next[0]] = next[1];
				
				//step2
				for(int j = 0; j < graph[next[0]].size(); j++) {
					//인근을 보고 방문체크 확인 및 주변과 비교하기
					int[] nnxt = graph[next[0]].get(j);  // 인근 요소
					
					if(!visited[nnxt[0]] && result[nnxt[0]] > nnxt[1]) {  // 해당 부분 수정  next[1] + nnxt[1];
						result[nnxt[0]] = nnxt[1];
						pq.offer(new int[] {nnxt[0], result[nnxt[0]]});
						
					}
				}
				
			}
			
			// 해당 result들의 합 구하기
			long cnt = 0;
			for (int i = 1; i <= v; i++) {
//				System.out.println(i + "번째 result 요소: "+ result[i]);
				cnt += result[i];
			}
			
			System.out.println("#"+test+" "+cnt);
			
			
			
		}
		

	}

}
