
T = int(input())

for _ in range(T) :
    k = int(input())
    n = int(input())
    arr = [[0] + [0] * (n) for _ in range(k+1)]

    for i in range(n+1) :
        arr[0][i] = i

    for j in range(1, k + 1) :
        arr[j][1] = j
    # print(arr)
    for x in range(1,k+1) :
        for y in range(1,n+1) :
            arr[x][y] = arr[x-1][y] + arr[x][y-1]

    ans = arr[k][n]
    print(ans)