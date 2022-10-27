a = 0
while a<=100:
    a = a+1
    for b in range(2, 100):
        for c in range(b, 100):
            for d in range(c, 100):
                if a**3 == b**3 + c**3 + d**3:
                    print("Cube = {}, Triple = ({},{},{})".format(a,b,c,d))
                else:
                    continue