import sys
T = int(input())

datas = []
for i in range(T):
    datas.append(sys.stdin.readline().strip().replace(" ",""))
    counts = dict() #초기화 문제 이해가 안간다.
    for data in datas[i] :
        if data not in counts: 
            counts[data] = 1
        else :
            counts[data] = counts[data] + 1
            
    all_values = counts.values()
    all_values = list(all_values)

    max_value = max(all_values)
    max_key = max(counts, key = counts.get)
    if all_values.count(max_value) > 1:
        print("?")
    else:
        print(max_key)