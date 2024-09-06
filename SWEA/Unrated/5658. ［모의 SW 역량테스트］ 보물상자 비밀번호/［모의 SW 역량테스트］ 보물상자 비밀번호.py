# import sys
# sys.stdin = open('input.txt','r')


for t in range(1, int(input()) + 1):
    N, K = map(int, input().split())  # N과 K 입력 받기
    num = input() # 보물 상자 숫자 문자열 입력
    d = N // 4  # 각 변의 길이

    # 숫자 회전 시 경계를 넘는 경우를 처리하기 위해 앞 부분을 뒤에 추가
    num += num[:d]

    arr = set()  # 중복을 제거하기 위해 set 사용
    for i in range(d):
        for j in range(4):
            # 각 변의 숫자 조합을 16진수로 변환
            s = int(num[(i + j * d):(i + j * d) + d], 16)
            arr.add(s)  # set에 추가하여 중복 제거

    # 내림차순으로 정렬 후 K번째로 큰 값 출력
    arr = sorted(arr, reverse=True)
    print(f'#{t} {arr[K - 1]}')
