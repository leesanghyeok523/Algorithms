from collections import deque

INF = float('inf')

# BFS 함수 정의: 출발지 (si, sj)에서 도착지 (ei, ej)까지 최소 복구 비용을 구하는 함수
def bfs(si, sj, ei, ej):
    q = deque()
    
    v = [[INF] * N for _ in range(N)]

    # 시작점 (si, sj)를 큐에 추가하고, 방문 리스트에 해당 위치의 복구 비용을 기록
    q.append((si, sj))
    v[si][sj] = arr[si][sj]

    # BFS 탐색
    while q:
        # 현재 위치 (ci, cj)를 큐에서 꺼냄
        ci, cj = q.popleft()

        # 상하좌우 4방향에 대해 탐색
        for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            ni, nj = ci + di, cj + dj  # 다음 위치

            # 다음 위치가 지도 내에 있고, 현재 경로가 더 짧다면 큐에 추가
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj] > v[ci][cj] + arr[ni][nj]:
                q.append((ni, nj))
                # 다음 위치까지의 최소 복구 비용을 갱신
                v[ni][nj] = v[ci][cj] + arr[ni][nj]

    # 도착지점 (ei, ej)의 최소 복구 비용 반환
    return v[ei][ej]

T = int(input()) 
for t in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input())) for _ in range(N)]

    # 시작점(0, 0)에서 도착점(N-1, N-1)까지의 최소 복구 비용을 계산
    ans = bfs(0, 0, N-1, N-1)

    print(f'#{t} {ans}')
