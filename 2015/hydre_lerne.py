#python3.6.3

# nbTetesOrig = 6
nbTetesOrig = 8542

nbTetes = nbTetesOrig
nbCoups = 0

while nbTetes > 1:
	nbTetes -= nbTetes/2

	if nbTetes != 1 and nbTetes%2 != 0:
		nbTetes *= 3
		nbTetes += 1

	nbCoups += 1

	if nbTetes == 1:
		nbCoups += 1

print(nbCoups)