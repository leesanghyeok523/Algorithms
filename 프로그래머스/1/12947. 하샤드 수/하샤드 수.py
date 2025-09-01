def solution(x):
    s = str(x)
    plus = 0
    for i in s :
        plus += int(i)
    
    print(plus)
    return x % plus == 0