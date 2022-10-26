import sys

T = int(input())

for i in range(T):
    n,m = map(int, sys.stdin.readline().split())
    count = 0
    for i in range(1,n):
        for j in range(i+1,n):
            #print(i,j)
            if ((i*i) + (j*j) + m)%(i*j) == 0:
                count += 1
            else:
                continue
    print(count)