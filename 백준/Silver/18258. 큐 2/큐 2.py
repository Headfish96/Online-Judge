from collections import deque
import sys

N = int(input())
queue = deque()
for i in range(N):
    order = sys.stdin.readline().split()
    if order[0] == "push":
        queue.append(order[1])
    elif order[0] == "pop":
        if not queue:
            print("-1")
        if queue:
            print(queue.popleft())
    elif order[0] == "size":
        print(len(queue))
    elif order[0] == "empty":
        if not queue:
            print("1")
        if queue:
            print("0")
    elif order[0] == "front":
        if not queue:
            print("-1")
        if queue:
            print(queue[0])
    elif order[0] == "back":
        if not queue:
            print("-1")
        if queue:
            print(queue[-1])