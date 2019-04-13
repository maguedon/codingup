
def toLower(char):
	eList = ('é', 'è', 'ê', 'ë')
	aList = ('à', 'â', 'ä')
	iList = ('î', 'ï')
	uList = ('û', 'ü', 'ù')
	oList = ('ô', 'ö')

	char = char.lower()
		
	if char in eList:
		char = 'e'
	elif char in aList:
		char = 'a'
	elif char in iList:
		char = 'i'
	elif char in uList:
		char = 'u'
	elif char in oList:
		char = 'o'

	return char

def getTabNbChar(mot):
	tab = {}
	for char in mot:
		if char not in (' ', '-', '_'):
			char = toLower(char)

			if char in tab:
				tab[char] = tab[char] + 1
			else:
				tab[char] = 1

	return tab


with open('legende_anagramme_entree_2.txt', 'r', encoding='utf8') as f:
    file = f.read()
    mots = file.split("\n")

tab = []

for mot in mots:
	tabNbChar = getTabNbChar(mot)

	if tab:
		i = 0
		wordAdded= False
		for i in range(len(tab)):
			listeMot = tab[i]
			firstWord = listeMot[0]

			tabNbChar2 = getTabNbChar(firstWord)

			if (tabNbChar2 == tabNbChar):
				tab[i].append(mot)
				wordAdded = True

		if not wordAdded:
			tab.append([mot])

	else:
		tab.append([mot])


# print(tab)

maxList = 0
maxCount = 0

for liste in tab:
	taille = len(liste)

	if taille > maxCount:
		maxCount = taille
		maxList = liste

print(maxList)

# Marchand, Marechal, Adam, Marchal