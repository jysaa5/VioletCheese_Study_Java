package kakao.kakaoCode.preliminary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 문제: 카카오프렌즈 컬러링북
/*
문제 설명
카카오 프렌즈 컬러링북
출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. 
(영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

alt text

위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

입력 형식
입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 
제한조건은 아래와 같다.

1 <= m, n <= 100
picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
출력 형식
리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

예제 입출력
m |	n	| picture                                                                              |	answer
6 |	4	|[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]  |	[4, 5]
예제에 대한 설명
예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 
가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.

*/
// 솔루션: BFS

// Point 클래스: 좌표를 저장
class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	
	// visited: 방문 여부, picture: 그림 상태, start: 현재 지점의 좌표
	public int BFS(boolean[][] visited, int[][] picture, Point start) {
		
		// 큐 선언 
		Queue<Point> queue = new LinkedList<>();
		
		// (-1, 0), (1, 0), (0, 1), (0, -1)
		// 왼쪽, 오른쪽, 위, 아래
		int[] dx = {-1, 1, 0 , 0};
		int[] dy = {0, 0, 1, -1};
		int area = 1;
		// 동서
		int nx;
		// 남북
		int ny;
		
		visited[start.x][start.y] = true;
		// queue에 추가
		queue.offer(start);

		// queue가 빌때까지 
		while(!queue.isEmpty()) {
			// queue에서 데이터를 꺼낸다.
			Point cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;
				
				if(0 <= nx && nx <picture.length && 0 <= ny && ny < picture[0].length) {
					
					if(!visited[nx][ny] && picture[nx][ny] != 0 && picture[cur.x][cur.y] == picture[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
						area++;
					}
					
				}
				
			}
			
		}
		
		return area;
	}

    public int[] solution(int m, int n, int[][] picture) {
        //int numberOfArea = 0;
        //int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        // answer[0] = 영역의 총 갯수
        // answer[1] = 최대 영역의 넓이
        
        //answer[0] = numberOfArea;
        //answer[1] = maxSizeOfOneArea;
        
        // 해당 지점을 방문했는지 여부를 체크
        boolean[][] visited = new boolean[m][n];
        
        // visited 배열을 false로 초기화
        for(int i=0; i<m; i++) {
        	Arrays.fill(visited[i], false);
        }
        
        for(int x=0; x<m; x++) {
        	for(int y=0; y<n; y++) {
        		
        		// 해당 지점을 방문한 적이 있거나, 해당 지점이 영역이 아닐때. -> 다른 지점을 확인
        		if(visited[x][y] || picture[x][y] == 0) {
        			continue;
        		}
        		// 최대 영역으로 갱신
        		answer[1] = Math.max(answer[1], BFS(visited, picture, new Point(x,y)));
        		answer[0]++;
        	}
        }
        
     
        
        
        
        return answer;
    }
}

public class KakaoFriends_ColoringBook_Sol_01 {
	public static void main(String[] arghs){
		
		int[][] picture = {{1, 1, 1, 0},
				           {1, 2, 2, 0}, 
				           {1, 0, 0, 1}, 
				           {0, 0, 0, 1}, 
				           {0, 0, 0, 3}, 
				           {0, 0, 0, 3}};
		
		int m = 6;
		int n = 4;
		Solution sol = new Solution();
		
		for(int i : sol.solution(m, n, picture)) {
			System.out.print(i+" ");
		}
		
		
	}
}