def solution(absolutes, signs):
    
    answer = 0
    for i in range(0, len(absolutes)) :
        if signs[i] == False :
            answer += -1 * absolutes[i]
        else :
            answer += absolutes[i]
    
    return answer