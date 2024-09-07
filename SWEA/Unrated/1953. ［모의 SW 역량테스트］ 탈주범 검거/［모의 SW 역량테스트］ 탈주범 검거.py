# import sys
from collections import deque

# sys.stdin = open('input.txt','r')

# 각 터널 타입에 따른 상하좌우 방향 연결 여부 설정
pipe = [[0,0,0,0], [1,1,1,1], [1,1,0,0], [0,0,1,1], [1,0,0,1], [0,1,0,1], [0,1,1,0], [1,0,1,0]]

# 반대 방향 설정 (상, 하, 좌, 우에 대한 반대 방향)
opp = [1, 0, 3, 2]

# 방향 설정 (상, 하, 좌, 우)
di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

def bfs(si, sj):
    # BFS를 위한 큐와 방문 배열 설정
    q = deque()
    v = [[0] * M for _ in range(N)]
    ans = 0

    # 초기 위치 설정
    q.append((si, sj))
    v[si][sj] = 1
    ans += 1

    while q:
        ci, cj = q.popleft()  # 큐에서 현재 위치를 꺼냄
        if v[ci][cj] == L:  # 현재 시간이 L과 같으면 더 이상 진행하지 않음
            return ans

        # 4방향 탐색 (상, 하, 좌, 우)
        for dr in range(4):
            ni, nj = ci + di[dr], cj + dj[dr]
            # 다음 위치가 지도 범위 내에 있고, 아직 방문하지 않았으며, 현재 터널과 다음 터널이 연결되어 있는지 확인
            if 0 <= ni < N and 0 <= nj < M and v[ni][nj] == 0 and pipe[arr[ci][cj]][dr] == 1 and pipe[arr[ni][nj]][opp[dr]] == 1:
                q.append((ni, nj))
                v[ni][nj] = v[ci][cj] + 1
                ans += 1  # 방문 가능한 장소의 개수 증가
    return ans

# 입력 처리 및 테스트 케이스 실행
for t in range(1, int(input()) + 1):
    N, M, R, C, L = map(int, input().split())  # N: 세로, M: 가로, R: 맨홀 세로 위치, C: 맨홀 가로 위치, L: 시간
    arr = [list(map(int, input().split())) for _ in range(N)]

    ans = bfs(R, C)
    print(f'#{t} {ans}')
