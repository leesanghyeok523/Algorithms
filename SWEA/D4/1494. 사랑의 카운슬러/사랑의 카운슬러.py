from itertools import combinations
 
 
for t in range(1, int(input()) + 1):
    N = int(input())
    points = []
    for _ in range(N):
        x, y = map(int, input().split())
        points.append((x, y))
 
    min_sum = float('inf')
 
    for selected in combinations(range(N), N // 2):
        x_sum = 0
        y_sum = 0
        for i in range(N):
            if i in selected:
                x_sum += points[i][0]
                y_sum += points[i][1]
            else:
                x_sum -= points[i][0]
                y_sum -= points[i][1]
        vector_sum = x_sum * x_sum + y_sum * y_sum
        min_sum = min(min_sum, vector_sum)
 
    print(f"#{t} {min_sum}")
    