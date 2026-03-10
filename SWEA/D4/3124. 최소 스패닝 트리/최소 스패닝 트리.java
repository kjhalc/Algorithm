import java.util.*;
import java.io.*;

public class Solution {
	
	static StringTokenizer st;
	static int v, e;
//	static Edge[] parent;
	static int[] parent;
	static Edge[] edgeList;
	static long result;
	
	static public class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			
			st = new StringTokenizer(br.readLine());
			
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			result = 0;

			edgeList = new Edge[e];
			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgeList);
			
			// 입력 후 정렬까지 완료
			
			make();
			int count = 0;
			
			// 정점 - 1 만큼일테니까 mst 간선갯수
				
				// 일단 1개를 꺼내고
				
				// 꺼낸 게 기존과 부모가 같은지 확인
				// 다르면 연결 후 웨이트 합치기
				
				//만약에 싸이클 생기면(부모가다르면 ) 건너뛰기
				
				//count == v-1이면 탈출
				

			
			
			for(int i = 0; i < e; i++) {
				
				

				if(union(edgeList[i].from, edgeList[i].to)) {
					result += edgeList[i].weight;
					
					if(count == v-1) {
						break;
					}

				}

			}
			
			System.out.println("#"+test+" "+result);
			
			
			
			
			
		}
	}
	
	static void make() {  // 부모 배열을 만들고 자기 자신으로 초기화
		
		parent = new int[v+1];
		
		for(int i = 1; i <= v; i++) {
			parent[i] = i;
		}

	}
	
	static int find(int n) {  // 간선 n이 속한 집합의 최고 부모 찾기
		
		if(parent[n] == n) {
			return n;
		}
		
		return parent[n] = find(parent[n]);
		
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return false;
		}
		
		parent[rootA] = rootB;
		return true;
	}

}
