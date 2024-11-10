# import sys
# sys.stdin = open('input.txt','r')

from collections import deque

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(maps):
    min_time = [[float('inf')] * N for _ in range(N)]
    min_time[0][0] = maps[0][0]
    queue = deque([(0, 0)])

    while queue:
        x, y = queue.popleft()

        # 현재 위치에서 네 방향 탐색
        for dx, dy in dir:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N:
                if min_time[x][y] + maps[nx][ny] < min_time[nx][ny]:
                    min_time[nx][ny] = min_time[x][y] + maps[nx][ny]
                    queue.append((nx, ny))

    return min_time[N - 1][N - 1]


T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    maps = [list(map(int, input())) for _ in range(N)]

    start = (0,0)
    end = (N-1,N-1)

    ans = bfs(maps)
    print(f'#{test_case} {ans}')
