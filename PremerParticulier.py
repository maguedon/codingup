#python3.7.2

def isPremier(n):
	isPremier = True
	if n > 2:
	   for i in range(2, n):
	       if (n % i) == 0:
	           isPremier = False
	           break
	elif n == 1 or n == 0:
		isPremier = False

	return isPremier

n = 72

i = 0
nbPremiers = 0
nombre = 0

while nbPremiers != n:
	nombre = 25 * i + 26

	if isPremier(nombre):
		nbPremiers = nbPremiers + 1

	i = i + 1

print(nombre, i - 1)