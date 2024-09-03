def solve() :
    schedules.sort(key=lambda x: (x[1], x[0]))
    cnt = 0
    end_time = 0
    for s, e in schedules:
        if s >= end_time:
            cnt += 1
            end_time = e

    return cnt


N = int(input())
schedules = []
for _ in range(N) :
    s, e = map(int,input().split())
    schedules.append((s,e))

ans = solve()
print(ans)

