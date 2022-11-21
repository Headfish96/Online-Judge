import itertools as it

numbers = []
for i in range(9):
    numbers.append(int(input()))

for combi in it.combinations(numbers, 7):
    if sum(combi) == 100:
        for i in sorted(combi):
            print(i)
        break
