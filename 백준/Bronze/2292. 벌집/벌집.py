def find_room(N) :
    if N == 1 :
        return 1

    count = 1
    c_room = 1

    while c_room < N :
        c_room += count * 6
        count += 1

    return count

N = int(input())

print(find_room(N))
