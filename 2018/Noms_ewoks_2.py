#python3.7.2

with open('noms_ewok2.txt', 'r') as f:
    file = f.read()
    mots = file.split("\n")

nbMots = 0

voyelles = ['a', 'e', 'i', 'o', 'u', 'y']
noms = []

for mot in mots:
	nbVoyelles = 0
	nbConsonnes = 0
	
	mot = mot.lower()

	for char in mot:
		if (char in voyelles):
			nbVoyelles += 1
		else:
			nbConsonnes += 1

	if nbVoyelles * 2 == nbConsonnes:
		noms.append(mot)

print(noms)
print(len(noms))