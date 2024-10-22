def is_prime(number) :
    if number < 2 :
        return
    for i in range(2, number // 2 + 1):
        if number % i == 0 :
            return False
    return True

N = int(input())
numbers = list(map(int,input().split()))

count = 0
for number in numbers :
    if is_prime(number) :
        count += 1

print(count)