N, M = map(int,input().split())
not_listen = set(input() for _ in range(N))
not_seen = set(input() for _ in range(M))

ans_arr = []

L = len(not_listen)
S = len(not_seen)

if L > S :
    not_listen, not_seen = not_seen, not_listen

count = 0
for mem in not_listen :
    if mem in not_seen :
        count += 1
        ans_arr.append(mem)

ans_arr.sort()

print(count)
for ans in ans_arr :
    print(ans)
