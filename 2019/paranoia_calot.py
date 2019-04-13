def getChar(char, decalage):
	ligne1 = ['a', 'z', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p']
	ligne2 = ['q','s','d','f','g','h','j','k','l','m']
	ligne3 = ['w','x','c','v','b','n',",",';',':','!']

	if char in ligne1:
		ligne = ligne1
	elif char in ligne2:
		ligne = ligne2
	elif char in ligne3:
		ligne = ligne3

	index = ligne.index(char)

	newIndex = index + decalage
	if (newIndex >= len(ligne)):
		newIndex = newIndex - len(ligne)
	elif (newIndex < 0):
		newIndex = len(ligne) - abs(newIndex)

	return ligne[newIndex]

tab = {}

with open('paranoia_calot_entree.txt', 'r', encoding='utf8') as f:
    for line in f:
    	for ch in line:
    		for decalage in range(-9, 9):
    			index = decalage + 9
    			if ch != '\n':
    				newChar = getChar(ch, decalage)
    			else:
    				newChar = ch

    			if index in tab:
    				tab[index] = tab[index] + newChar
    			else:
    				tab[index] = newChar
print(tab[13])