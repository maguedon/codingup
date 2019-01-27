#python3.6.3

from collections import Counter
import math

def isPremier(n):
	isPremier = True
	for i in range(2, n):
		if (n%i) == 0:
			isPremier = False

	return isPremier

def getFacteurs(n):
	divise = n
	diviseurs = []
	finDivisions = False

	while not finDivisions:
		divisible = False

		j = int(math.sqrt(divise) + 1)

		if j%2 == 0:
			j -= 1

		while j > 1 and not divisible:
			if isPremier(j) and divise%j == 0:
				diviseurs.append(j) 
				divise = int(divise/j)
				divisible = True

			if j > 3:
				j -= 2
			else:
				j -= 1

		if not divisible:
			diviseurs.append(divise)
			finDivisions = True

	return diviseurs



def isFrugal(n):
	facteurs = getFacteurs(n)

	occurences = Counter(facteurs)
	occurences = occurences.most_common(len(occurences))

	sizeDecomposition = 0

	for i in occurences:
		sizeDecomposition += len(str(i[0]))

		if i[1] > 1:
			sizeDecomposition += len(str(i[1]))

	sizeNumber = len(str(n))

	return sizeNumber > sizeDecomposition


def nbNombresFrugaux(debut, fin):
	nbNombresFrugaux = 0

	for i in range(debut, fin+1):
		# print(i)
		if isFrugal(i):
			nbNombresFrugaux += 1

	return nbNombresFrugaux



nbNombresFrugaux = nbNombresFrugaux(123456, 165432)

print(nbNombresFrugaux)
