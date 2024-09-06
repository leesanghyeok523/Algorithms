# import sys
# sys.stdin = open('input.txt','r')

di = [1,-1,0,0]
dj = [0,0,-1,1]

for t in range(1, int(input()) + 1) :
    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]

    for i in range(N) :
        arr[i][0] *= 2
        arr[i][1] *= 2
    ans = 0

    for _ in range(4001) :
        # [0] : j [1] : i [2] : dr [3] : e
        for i in range(len(arr)) :
            arr[i][0] += dj[arr[i][2]]
            arr[i][1] += di[arr[i][2]]

        v, ddel = set(), set()
        for i in range(len(arr)) :
            cj, ci = arr[i][0], arr[i][1]
            if (cj, ci) in v :
                ddel.add((cj,ci))
            else :
                v.add((cj,ci))

        for i in range(len(arr)-1, -1, -1) :
            if (arr[i][0], arr[i][1]) in ddel :
                ans += arr[i][3]
                arr.pop(i)
            elif max(abs(arr[i][0]), abs(arr[i][1])) > 2000 :
                arr.pop(i)

    print(f'#{t} {ans}')

