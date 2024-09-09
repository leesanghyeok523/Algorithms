def shoot(ball, count, org):  # ball 구슬 순서, count 남은 벽돌, org 현재 벽돌 배치
    global min_v
    if ball == N or count == 0:  # 구슬을 모두 발사했거나 남은 벽돌이 없는 경우
        min_v = min(min_v, count)  # 남은 최소 벽돌 갱신
        return
    for j in range(W):  # 다른 열에 쏘기
        dest = [row[:] for row in org]  # 벽돌을 깬 결과 저장용
        tmp = []  # 깨지면서 주변에 영향을 주는 벽돌 목록
        for i in range(H):  # 구슬을 쏘는 열에서 가장 위 벽돌찾기
            if dest[i][j]:  # 벽돌이 있으면
                n_count = count - 1  # 남은 벽돌 수, 열을 바꿀 때마다 초기화
                tmp.append([i, j, dest[i][j]])  # 깨진 벽돌 정보 저장
                dest[i][j] = 0
                break  # 구슬이 깬 벽돌 처리완료
        else:  # 만약 비어있는 열이면 다음 열로 발사위치 이동
            continue
        while tmp:  # 구슬에 맞은 벽돌에 의해 추가로 깨지는 벽돌 찾기
            i, j, p = tmp.pop()
            for k in range(1, p):
                for di, dj in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                    ni, nj = i + di * k, j + dj * k
                    if 0 <= ni < H and 0 <= nj < W and dest[ni][nj]:
                        if dest[ni][nj] > 1:  # 주변에 영향을 줄 때만 저장
                            tmp.append([ni, nj, dest[ni][nj]])
                        dest[ni][nj] = 0  # 깨진 벽돌
                        n_count -= 1  # 남은 벽돌 감소
        for j in range(W):  # 빈칸 메꾸기
            idx = H - 1
            for i in range(H - 1, -1, -1):
                if dest[i][j]:
                    dest[i][j], dest[idx][j] = dest[idx][j], dest[i][j]
                    idx -= 1
        shoot(ball + 1, n_count, dest)


T = int(input())
for tc in range(1, T + 1):
    N, W, H = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(H)]
    min_v = 12 * 15  # 남은 최소 벽돌 초기화
    block_num = 0  # 초기 벽돌 개수
    for row in arr:
        for b in row:
            if b:  # 0이 아니면 벽돌
                block_num += 1
    shoot(0, block_num, arr)
    print(f'#{tc} {min_v}')