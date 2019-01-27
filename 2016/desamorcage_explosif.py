#python3.6.3

# numSerie = '317010'
numSerie = '449149'
middle = int(len(numSerie)/2)

u = numSerie[0:middle]
n = numSerie[middle:len(numSerie)]
u = int(u)
n = int(n)

for i in range(n):
	u *= 13
	u = str(u)[-3:]
	u = int(u)

print(u)