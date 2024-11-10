def dfs(n, sm, plus, minus, multiple, divide) :
    global mx, mn

    if n == N :
        mx = max(mx, sm)
        mn = min(mn, sm)
        return

    if plus > 0 :
        dfs(n + 1, sm + lst[n], plus-1, minus, multiple, divide)
    if minus > 0:
        dfs(n + 1, sm - lst[n], plus, minus - 1, multiple, divide)
    if multiple > 0:
        dfs(n + 1, sm * lst[n], plus, minus, multiple - 1, divide)
    if divide > 0:
        dfs(n + 1, int(sm / lst[n]), plus, minus, multiple, divide - 1)


N = int(input())
lst = list(map(int,input().split()))
plus, minus, multiple, divide = map(int,input().split())

mx = int(-1e9)
mn = int(1e9)
dfs(1, lst[0], plus, minus, multiple, divide)
print(mx)
print(mn)
