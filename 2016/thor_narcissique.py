#python3.6.3

from collections import Counter

prenom = "thor"
nbLettresPrenom = len(prenom)

mots = []

with open('mots_thor.txt', 'r') as f:
    file = f.read()
    mots = file.split("\n")

nbMots = 0

for i in range(len(mots)):
	counterMot = Counter(mots[i])

	correctWord = True
	for j in range(nbLettresPrenom):
		lettre = prenom[j]
		if (counterMot[lettre] != 1):
			correctWord = False

	if correctWord:
		nbMots += 1

print(nbMots)