#python3.6.3

entree = 1325
somme = 0

for i in range(entree):
	if i%5 == 0 or i%3 == 0:
		somme += i

print(somme)