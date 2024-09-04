def dfs(n, sm) :
    global ans
    if n > 12 :
        ans = min(ans, sm)
        return ans

    dfs(n+1, sm + schedules[n] * day)
    dfs(n+1, sm + month1)
    dfs(n+3, sm + month3)
    dfs(n + 12, sm + year)


for t in range(1, int(input()) + 1) :
    day, month1, month3, year = map(int,input().split())
    schedules = [0] + list(map(int,input().split()))

    ans = float('inf')
    dfs(1,0)
    print(f'#{t} {ans}')