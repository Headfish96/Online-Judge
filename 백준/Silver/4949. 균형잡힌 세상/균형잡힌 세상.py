while True:
    a = input()
    stack = []
    if a == '.':
        break

    for i in a:
        if i == '(':
            stack.append(i)
        elif i == '[':
            stack.append(i)
        elif i == ')':
            if not stack:
                print("no")
                break
            elif stack[-1] == '(':
                stack.pop()
            else:
                print("no")
                break
        elif i == ']':
            if not stack:
                print("no")
                break
            elif stack[-1] == '[':
                stack.pop()
            else:
                print("no")
                break
    else:
        if not stack:
            print("yes")
        else:
            print("no")

