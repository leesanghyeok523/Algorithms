# import sys
# sys.stdin = open('input.txt', 'r')

dx = [0,0,-1,1]
dy = [-1,1,0,0]
# 시작점 : 각 좌표
# 끝점 : 문자열의 길이가 7이면 종료
def dfs(y,x,path) :
    if len(path) == 7 :
        result.add(path) # 현재까지의 경로를 결과 set에 저장
        return

    #상하좌우 확인하면서 갈 수 있으면 이동
    for i in range(4) :
        ny = y + dy[i]
        nx = x + dx[i]

        # 범위 체크
        if ny < 0 or ny >= 4 or nx < 0 or nx >= 4 :
            continue

        dfs(ny,nx, path + arr[ny][nx]) # 문자열을 누적하면서 다음으로 이동

for t in range(1, int(input()) + 1) :
    # 문자로 쓰면 합치기 더 쉽기 때문에, 각 칸을 문자로 입력받음
    arr = [input().split() for _ in range(4)]
    # 중복을 제거하기 위해
    result = set()

    # 모든 지점을 확인
    for i in range(4) :
        for j in range(4) :
            dfs(i, j, arr[i][j])
    print(f'#{t} {len(result)}')