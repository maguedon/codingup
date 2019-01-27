#python3.6.3

nbEtages = 50
somme = 0

for i in range(nbEtages + 1):
	nbPommes = i * i
	if nbPommes % 3 == 0:
		somme += nbPommes

print(somme)