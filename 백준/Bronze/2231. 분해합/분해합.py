def digit_sum(N) :
    result = 0
    N = str(N)
    for digit in N :
        result += int(digit)
    return result


def sol(a) :
    for i in range(N) :
        if i + digit_sum(i) == N :
            return i
    return 0


N = int(input())
ans = sol(N)
print(ans)
