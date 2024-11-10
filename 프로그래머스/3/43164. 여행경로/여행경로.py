def solution(tickets):
    
    def dfs(airport):
        # 현재 공항에서 가능한 모든 경로 탐색
        while airport in graph and graph[airport]:
            next_airport = graph[airport].pop()
            dfs(next_airport)
        # 역순으로 경로를 저장
        route.append(airport)
        
    # 인접 리스트 생성
    graph = {}
    for a, b in tickets:
        if a not in graph:
            graph[a] = []
        graph[a].append(b)

    # 각 출발 공항의 도착 공항 리스트를 사전순으로 정렬 (역순 정렬)
    for key in graph:
        graph[key].sort(reverse=True)

    route = []

    # ICN에서 출발
    dfs("ICN")
    # 경로를 뒤집어서 반환 (역순으로 저장되었기 때문)
    return route[::-1]