#python3.6.3

n = 242

somme = 0

for i in range(1, n+1):
	if '9' not in str(i):
		somme += (1 / i)

print(somme)