def min_socks_cost(N, X, A):
    min_cost = float('inf')
    for i in range(N - 1):
        cost = (A[i] + A[i + 1]) * X
        min_cost = min(min_cost, cost)
    return min_cost

# 입력 예시
N, X = map(int, input().split())
A = list(map(int, input().split()))

# 결과 출력
print(min_socks_cost(N, X, A))
