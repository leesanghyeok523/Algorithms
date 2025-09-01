def solution(n):
    n = n - 1
    answer = 0
    
    for i in range(n, 1, -1) :
        if (n % i == 0) :
            answer = i
            
    return answer