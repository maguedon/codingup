
def toLower(char):
	eList = ('é', 'è', 'ê', 'ë')
	aList = ('à', 'â', 'ä')
	iList = ('î', 'ï')

	char = char.lower()
		
	if char in eList:
		char = 'e'
	elif char in aList:
		char = 'a'
	elif char in iList:
		char = 'i'

	return char



with open('legende_anagramme_entree.txt', 'r', encoding='utf8') as f:
    file = f.read()
    mots = file.split("\n")

nom = "Pierre Maréchal"
# print(mots)
tab = {}

for char in nom:
	if char != ' ':
		char = toLower(char)

		if char in tab:
			tab[char] = tab[char] + 1
		else:
			tab[char] = 1

print(tab)

wordFind = False
i = 0

while (not wordFind) and (i < len(mots)):
	mot = mots[i]
	wrongLetter = False

	for char in tab:
		countChar = 0
		for char2 in mot:
			char2 = toLower(char2)
			if char == char2:
				countChar = countChar + 1

		if countChar != tab[char]:
			wrongLetter = True

	if not wrongLetter:
		wordFind = True
		print(mot)

	i = i + 1
