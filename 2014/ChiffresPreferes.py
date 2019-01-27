#python3.7.2

n1 = 140
n2 = 1007

somme = 0

for i in range(n1, n2 + 1):
	if '7' in str(i) or '4' in str(i):
		somme = somme + i

print(somme)