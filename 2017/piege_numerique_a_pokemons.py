#python3.6.3

goodNumbers = []

for i in range(1000):
    if i%7 == 0:
        strNum = str(i)
        somme = 0
        
        for s in strNum:
            somme += int(s)
            
        if (somme == 11):
            goodNumbers.append(strNum)

print(','.join(goodNumbers))
