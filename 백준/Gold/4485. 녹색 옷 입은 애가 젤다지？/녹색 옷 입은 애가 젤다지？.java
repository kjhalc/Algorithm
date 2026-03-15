import java.util.*;
import java.io.*;

public class Main {
	static StringTokenizer st;
	static int n;
	static int[][] grid, dist;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	static int test = 1;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			n = Integer.parseInt(br.readLine());
			
			grid = new int[n+1][n+1];
			dist = new int[n+1][n+1];
			if(n==0) break;
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(1, 1);
			System.out.println("Problem "+ test + ": "+dist[n][n]);
			test++;
			
			
		}
		
	}
	
	static void bfs(int x, int y) {
		
		Queue<int[]> q = new ArrayDeque<>();
		dist[x][y] = grid[x][y];
		q.offer(new int[] {x, y});
		
//		// 디버깅 용 현재까지 패턴출력 로직
//		for(int p = 1; p<=n; p++) {
//			for(int p2 = 1; p2<=n; p2++) {
//				System.out.print(dist[p][p2]+ " ");
//			}
//			System.out.println();
//		}
//		
//System.out.println();
//System.out.println();
		
		while(!q.isEmpty()) {
			
			int[] next = q.poll();
			
			for(int i = 0; i < 4; i ++) {
				int nx = next[0] + dx[i];
				int ny = next[1] + dy[i];
				
				if(1<=nx && 1<=ny && nx<=n && ny<=n && dist[next[0]][next[1]] + grid[nx][ny] < dist[nx][ny]) {
					// 범위 내이면서 다음 위치 거리정보가 현재 거리정보보다 크면 -> 업데이트 후 큐에넣기
					dist[nx][ny] = dist[next[0]][next[1]] + grid[nx][ny];
					
//					// 디버깅 용 현재까지 패턴출력 로직
//					for(int p = 1; p<=n; p++) {
//						for(int p2 = 1; p2<=n; p2++) {
//							System.out.print(dist[p][p2]+ " ");
//						}
//						System.out.println();
//					}
//					System.out.println();
//					System.out.println();
//					
//					
					q.offer(new int[] {nx, ny});
				}
			}
			
		}
	}

}
