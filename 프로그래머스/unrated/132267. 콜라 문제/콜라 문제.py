def solution(a,b,n):
    share = 0
    remain = 0
    rest = 0
    answer = 0
    while True:
        share = (n//a) * b #상빈이가 받게되는 병의 수
        remain = n%a #병을 반납했을때 남은 병의 수
        rest = share + remain #상빈이에게 남은 병의  총 수
        n = rest
        answer = answer + share
        if n < a:
            break
    return answer