from collections import deque

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def solution(maps):
    n = len(maps)
    m = len(maps[0])

    # 큐 초기화
    queue = deque([(0, 0)])

    while queue:
        x, y = queue.popleft()

        # 현재 위치에서 네 방향 탐색
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            # 맵을 벗어나지 않고, 벽이 아니며, 아직 방문하지 않은 경우
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1:
                # 이전 노드의 값에 1을 더해 최단 거리 갱신
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx, ny))

    # 상대 팀 진영의 값이 처음 시작 위치 값 그대로이면 도달 불가능
    return maps[-1][-1] if maps[-1][-1] != 1 else -1

