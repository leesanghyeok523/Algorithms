T = int(input())
for _ in range(T):
    a_str, b_str, c_str = input().split()
    a = int(a_str)
    b = int(b_str)
    c = int(c_str)
    s1 = (a + b) * (a + b) + c * c
    s2 = (a + c) * (a + c) + b * b
    s3 = (b + c) * (b + c) + a * a
    print(min(s1, s2, s3))
