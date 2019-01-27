#python3.7.2

with open('noms_ewok.txt', 'r') as f:
    file = f.read()
    mots = file.split("\n")

nbMots = 0

for i in range(len(mots)):
	mot = mots[i]
	nbLettres = len(mot)

	aPresent = False

	for j in range(nbLettres):
		lettre = mot[j]
		if (lettre.lower() == 'a'):
			aPresent = True

	if not aPresent:
		nbMots = nbMots + 1

print(nbMots)