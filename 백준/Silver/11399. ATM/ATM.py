N = int(input())
arr = list(map(int,input().split()))

arr.sort()
ans = 0
tmp = 0
for i in arr :
    tmp = tmp + i
    ans = ans + tmp
print(ans)