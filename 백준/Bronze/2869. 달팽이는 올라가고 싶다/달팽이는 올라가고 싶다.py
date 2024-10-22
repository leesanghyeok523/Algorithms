import math

A, B, V = map(int, input().split())

ans = (V - B) / (A - B)

print(math.ceil(ans))
