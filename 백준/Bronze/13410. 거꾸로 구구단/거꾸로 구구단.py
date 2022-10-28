
import sys
N, K = map(int, sys.stdin.readline().split())

ggdan = []
for i in range(1, K+1):
    ggdan.append(int(N*i))

for i in range(len(ggdan)):
    ggdan[i] = str(ggdan[i])
    ggdan[i] = ggdan[i][::-1]
    ggdan[i] = int(ggdan[i])
print(max(ggdan))