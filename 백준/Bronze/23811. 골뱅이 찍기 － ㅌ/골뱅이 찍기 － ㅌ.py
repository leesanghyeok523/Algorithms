def print_golbang(N):
    # 위 가로줄 출력 (N개의 셀로 구성된 5줄)
    for _ in range(N):
        print("@" * (5 * N))
    
    # 중간 세로줄 출력 (N개의 세로줄)
    for _ in range(N):
        print("@" * N)
    
    # 가운데 가로줄 출력 (N개의 셀로 구성된 5줄)
    for _ in range(N):
        print("@" * (5 * N))
    
    # 다시 중간 세로줄 출력 (N개의 세로줄)
    for _ in range(N):
        print("@" * N)
    
    # 아래 가로줄 출력 (N개의 셀로 구성된 5줄)
    for _ in range(N):
        print("@" * (5 * N))

# 입력받기
N = int(input())

# 골뱅이 모양 출력
print_golbang(N)
