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
		
		
		//// 여기서부터 step1 선택 step2 업데이트 반복
		
		for(int i = 1; i <= v; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		
		result[k] = 0;
		int count = 0;
		
		for(int i = 0; i < v; i++) {
			
			//step1: result중 방문 x이면서 값이 가장 작은 것 고르기
			int min = Integer.MAX_VALUE;
			int min_vertax = -1;
			
			for(int j = 1; j <= v; j++) {
				if(!visited[j] && min > result[j]) {
					min = result[j];
					min_vertax = j;
				}				
			}
			
			if(min_vertax == -1) break;  // 골라진 게 없으면 다 고른 것이므로 나가기
			if (count == v) break;
			
			// 고른거 방문체크 & 최솟값으로 업데이트.. 는 할필요없네
			visited[min_vertax] = true;
//			result[min_vertax] = min;
			
			// step2/ 업데이트 (고른것과 인접한 것들 중, 방문 x 면서 이전과 비교했을 때 더 작으면 result를 업데이트
			// System.out.println("현재 선택된 정점: " + min_vertax);
			for(int j = 0; j < graph[min_vertax].size(); j++) {
				int[] next = graph[min_vertax].get(j);  // 해당 정점과 연결된 요소들
				int to = next[0];
				int weight = next[1];
				
				if(!visited[to] && result[to] > result[min_vertax] + weight) {  //
					result[to] = result[min_vertax] + weight;
				}
			}
			
			
		}
		
		for(int p = 1; p <= v; p++) {
			if(result[p]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(result[p]);
			}
			
		}
		
	}
	
}
