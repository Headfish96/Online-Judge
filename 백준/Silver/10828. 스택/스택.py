import sys

N = int(input())
stack = []
for i in range(N):
    word = sys.stdin.readline().split()
    order = word[0]
    if order == "push":
        stack.append(word[1])
    elif order == "pop":
        if not stack:
            print("-1")
        if stack:
            print(stack.pop())
    elif order == "size":
        print(len(stack))
    elif order == "empty":
        if not stack:
            print("1")
        if stack:
            print("0")
    elif order == "top":
        if not stack:
            print("-1")
        if stack:
            print(stack[-1])
