def sortCards(cards):
	cards2 = []

	while(cards):
		if (len(cards) > 1):
			firstCard = cards.pop()
			cards.insert(0, firstCard)

		newFirstCard = cards.pop()
		cards2.append(newFirstCard)

	return cards2

cartes = []
nbCartes = 0
nbEtapesMax = 0

for i in range(1, 208):
	cartes.append(i)
	nbEtapes = 1
	previousSort = sortCards(cartes.copy())

	while(cartes != previousSort):
		previousSort = sortCards(previousSort.copy())
		nbEtapes = nbEtapes + 1

	if nbEtapes > nbEtapesMax:
		nbCartes = i
		nbEtapesMax = nbEtapes

	print(i, nbEtapes)


print(nbCartes, nbEtapesMax)

#172, 28852785