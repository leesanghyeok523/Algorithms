# import sys
# sys.stdin = open('input.txt', 'r')

# cost 룩업테이블 작성
cost = [(k ** 2 + (k - 1) ** 2) for k in range(22)]

for t in range(1, int(input()) + 1):
    N, M = map(int, input().split())  # M : 하나의 집이 지불할 수 있는 비용
    arr = [list(map(int, input().split())) for _ in range(N)]

    ans = 0
    # home의 좌표들을 추려놓기
    home = []
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1:
                home.append((i, j))

    # home의 좌표들을 기반으로 맨해튼 거리 구한 값을 dist에 추가

    for si in range(N):
        for sj in range(N):
            dist = [0] * 40
            for hi, hj in home:
                tmp = abs(si - hi) + abs(sj - hj) + 1
                dist[tmp] += 1
            # k를 확장시키며 운영비용보다 지불비용이 큰 값 +
            # 서비스 가능한 집이 많아지면 교체
            cnt = 0
            for k in range(1, 22):
                cnt += dist[k]
                if cost[k] <= cnt * M and ans < cnt:
                    ans = cnt

    print(f'#{t} {ans}')