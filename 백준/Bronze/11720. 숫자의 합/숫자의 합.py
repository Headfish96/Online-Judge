N = int(input())
number = input()
number_list = list(map(int, number))
sum = 0
for i in range(N):
    sum = sum + number_list[i]

print(sum)