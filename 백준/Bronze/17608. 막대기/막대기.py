N = int(input())
sticks = []
for _ in range(N):
    stick = int(input())
    sticks.append(stick)

cnt = 1
max_h = sticks[-1]

for i in range(N-2, -1, -1):
    if sticks[i] > max_h:
        cnt += 1
        max_h = sticks[i]

print(cnt)
