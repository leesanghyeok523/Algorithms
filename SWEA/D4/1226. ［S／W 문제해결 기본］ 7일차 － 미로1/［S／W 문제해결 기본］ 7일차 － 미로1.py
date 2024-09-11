# import sys
# sys.stdin = open('input.txt','r')
from collections import deque
di = [-1,1,0,0]
dj = [0,0,-1,1]

def bfs(si, sj) :
    q = deque()
    v = [[0] * N for _ in range(N)]

    q.append((si,sj))
    v[si][sj] = 1

    while q :
        ci, cj = q.popleft()
        if arr[ci][cj] == 3 :
            return 1
        for dr in range(4) :
            ni, nj = ci + di[dr], cj + dj[dr]
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj] == 0 and arr[ni][nj] != 1 :
                q.append((ni,nj))
                v[ni][nj] = 1

    return 0


for t in range(1, 11):
    _ = input()
    N = 16
    arr = [list(map(int,input())) for _ in range(N)]

    for i in range(N) :
        for j in range(N) :
            if arr[i][j] == 2 :
                si,sj = i, j
            if arr[i][j] == 3 :
                ei, ej = i, j

    result = bfs(si, sj)
    print(f'#{t} {result}')

