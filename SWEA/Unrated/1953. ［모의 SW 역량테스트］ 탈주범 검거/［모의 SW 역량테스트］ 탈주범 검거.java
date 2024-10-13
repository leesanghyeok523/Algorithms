

import java.util.*;

public class Solution {
    // 각 터널 타입에 따른 상하좌우 방향 연결 여부 설정
    static int[][] pipe = {
            {0, 0, 0, 0},  // 터널이 없는 곳
            {1, 1, 1, 1},  // 터널 타입 1: 상하좌우 이동 가능
            {1, 1, 0, 0},  // 터널 타입 2: 상하 이동 가능
            {0, 0, 1, 1},  // 터널 타입 3: 좌우 이동 가능
            {1, 0, 0, 1},  // 터널 타입 4: 상우 이동 가능
            {0, 1, 0, 1},  // 터널 타입 5: 하우 이동 가능
            {0, 1, 1, 0},  // 터널 타입 6: 하좌 이동 가능
            {1, 0, 1, 0}   // 터널 타입 7: 상좌 이동 가능
    };

    // 반대 방향 설정 (상, 하, 좌, 우에 대한 반대 방향)
    static int[] opp = {1, 0, 3, 2};

    // 방향 설정 (상, 하, 좌, 우)
    static int[] di = {-1, 1, 0, 0};  // 상, 하에 대한 행 이동
    static int[] dj = {0, 0, -1, 1};  // 좌, 우에 대한 열 이동

    // BFS 함수
    public static int bfs(int N, int M, int R, int C, int L, int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[N][M];  // 방문 여부 및 시간을 기록할 배열
        int ans = 0;  // 방문 가능한 지점의 수

        // 초기 위치 설정
        q.add(new int[]{R, C});
        visited[R][C] = 1;  // 맨홀 위치 방문 표시
        ans++;

        // BFS 탐색
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int ci = current[0];
            int cj = current[1];

            // 현재 시간이 L과 같으면 더 이상 진행하지 않음
            if (visited[ci][cj] == L) {
                return ans;
            }

            // 4방향 탐색 (상, 하, 좌, 우)
            for (int dr = 0; dr < 4; dr++) {
                int ni = ci + di[dr];
                int nj = cj + dj[dr];

                // 다음 위치가 지도 범위 내에 있고, 아직 방문하지 않았으며, 현재 터널과 다음 터널이 연결되어 있는지 확인
                if (ni >= 0 && ni < N && nj >= 0 && nj < M && visited[ni][nj] == 0
                        && pipe[arr[ci][cj]][dr] == 1 && pipe[arr[ni][nj]][opp[dr]] == 1) {
                    q.add(new int[]{ni, nj});
                    visited[ni][nj] = visited[ci][cj] + 1;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();  // 세로 크기
            int M = sc.nextInt();  // 가로 크기
            int R = sc.nextInt();  // 맨홀 세로 위치
            int C = sc.nextInt();  // 맨홀 가로 위치
            int L = sc.nextInt();  // 경과 시간

            int[][] arr = new int[N][M];  // 터널 지도를 입력 받음
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // BFS 실행
            int ans = bfs(N, M, R, C, L, arr);
            System.out.println("#" + t + " " + ans);  // 결과 출력
        }

        sc.close();
    }
}

