for t in range(1, int(input()) + 1) :
    A,B,C = map(int,input().split())

    if B < 2 or C < 3 : # A < B < C 구조를 만들 수 없는 케이스를 처리
        print(f'#{t} -1')
        continue

    eat = 0 # 먹은 사탕 갯수
    # 설계 : B가 C 이상일 때, B = C - 1 이라면 최소갯수
    if B >= C :
        eat += B - (C-1) # 차이만큼 먹음
        B = C - 1
    #        A가 B 이상일 때, A = B - 1이라면 최소 갯수
    if A >= B :
        eat += A - (B - 1)
        A = B - 1

    print(f'#{t} {eat}')