# 입력받기
STR, DEX, INT, LUK, N = map(int, input().split())

# 현재 스탯의 합 계산
current_sum = STR + DEX + INT + LUK

# 필요한 최소 축복 횟수 계산
required_blessings = max(0, 4 * N - current_sum)

# 결과 출력
print(required_blessings)
