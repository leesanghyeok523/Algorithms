N = int(input())
counts = [0] * 10001
for i in range(N) :
    number = int(input())
    counts[number] += 1

for i in range(10001) :
    if counts[i] > 0 :
        for _ in range(counts[i]) :
            print(i)
