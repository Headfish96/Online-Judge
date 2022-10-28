import sys
S = list(sys.stdin.readline().rstrip())

i = 0
start = 0

while i in range(len(S)):
    if S[i] == "<":       # 열린 괄호를 만나면
        i += 1 
        while S[i] != ">":      # 닫힌 괄호를 만날 때 까지
            i += 1 
        i += 1               # 닫힌 괄호를 만난 후 인덱스를 하나 증가시킨다
    elif S[i].isalnum(): # 숫자나 알파벳을 만나면
        start = i
        while i < len(S) and S[i].isalnum():
            i+=1
        tmp = S[start:i] # 숫자,알파벳 범위에 있는 것들을
        tmp.reverse()       # 뒤집는다
        S[start:i] = tmp
    else:                   # 괄호도 아니고 알파,숫자도 아닌것 = 공백
        i+=1                # 그냥 증가시킨다

print("".join(S))