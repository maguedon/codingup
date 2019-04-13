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



maxAscii = 127
resultat = ""

with open('mail.txt', 'r', encoding='utf8') as f:
    for line in f:
    	for ch in line:
    		ch = toLower(ch)
    		if ord(ch) > maxAscii and ch not in ("«", "»"):
    			resultat = resultat + ch

print(resultat)
