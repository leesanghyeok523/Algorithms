# import sys
# sys.stdin = open('input.txt','r')

# 운영 비용을 미리 계산해 두기 위한 리스트 생성
cost = [(k*k + (k-1)*(k-1)) for k in range(40)]


def solve() :
    ans = 0  
    home = []  # 집의 좌표
    for i in range(N) :
        for j in range(N) :
            if arr[i][j] == 1 :  
                home.append((i,j)) 

    for si in range(N) :
        for sj in range(N) :
            dist = [0] * 40  # 거리 별로 집의 수를 저장할 리스트
            for hi,hj in home :  
                t = abs(si-hi) + abs(sj-hj) + 1  # 서비스 영역 내에 포함된 거리 계산
                dist[t] += 1  # 해당 거리 t에 포함된 집의 수를 증가시킴

            cnt = 0  # 해당 서비스 영역 내에 포함된 집의 수를 카운트
            for k in range(1, 40) :
                cnt += dist[k]  # 거리 k까지 포함된 집의 수를 누적
                # 운영 비용이 수익을 충당할 수 있고, 더 많은 집에 서비스를 제공할 수 있는 경우
                if cost[k] <= cnt * K and ans < cnt :
                    ans = cnt 
    return ans  

# 입력 처리 및 테스트 케이스 실행
for t in range(1, int(input()) + 1) :
    N, K = map(int,input().split()) 
    arr = [list(map(int,input().split())) for _ in range(N)]  

    ans = solve()  
    print(f'#{t} {ans}')  
