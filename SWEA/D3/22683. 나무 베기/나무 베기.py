from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(my_position, target_position, K) :
    visited = [[[[False] * (K + 1) for _ in range(4)] for _ in range(N)] for _ in range(N)]
    q = deque()
    x, y = my_position

    q.append((x, y, 0, 0, K))
    visited[x][y][0][K] = True

    while q :
        x, y, dir, moves, cnt = q.popleft()

        nx = x + dx[dir]
        ny = y + dy[dir]

        if [nx,ny] == target_position :
            return moves + 1

        if 0 <= nx < N and 0 <= ny < N :
            if map_data[nx][ny] == 'G' and not visited[nx][ny][dir][cnt] :
                visited[nx][ny][dir][cnt] = 1
                q.append((nx,ny,dir, moves+1, cnt))
            elif map_data[nx][ny] == 'T' and cnt > 0 and not visited[nx][ny][dir][cnt-1] :
                visited[nx][ny][dir][cnt-1] = 1
                q.append((nx,ny,dir, moves+1, cnt-1))

        nd = (dir - 1) % 4
        if not visited[x][y][nd][cnt] :
            visited[x][y][nd][cnt] = 1
            q.append((x,y, nd, moves+1, cnt))

        nd = (dir + 1) % 4
        if not visited[x][y][nd][cnt] :
            visited[x][y][nd][cnt] = 1
            q.append((x,y,nd, moves+1, cnt))

    return -1

for t in range(1, int(input()) + 1) :
    N, K = map(int,input().split())
    map_data = [list(input()) for _ in range(N)]

    for x in range(N) :
        for y in range(N) :
            if map_data[x][y] == 'X' :
                my_position = [x,y]
            elif map_data[x][y] == 'Y' :
                target_position = [x,y]

    result = bfs(my_position, target_position, K)
    print(f'#{t} {result}')
