import sys

_ = sys.stdin.readline()
array = list(map(int, sys.stdin.readline().split()))

sort_unq_array = sorted(list(set(array)))

array_map = {key: value for value, key in enumerate(sort_unq_array)}

result = [array_map[c] for c in array]

print(*result)