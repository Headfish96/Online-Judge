N = int(input())
h = []
for i in range(N):
    h.append(int(input()))

left_count = 0
max_left = 0
for i in h:
    if i > max_left:
        max_left = i
        left_count += 1
    else:
        continue

right_count = 0
max_right = 0
for i in h[::-1]:
    if i > max_right:
        max_right = i
        right_count += 1
    else:
        continue
print(left_count)
print(right_count)
