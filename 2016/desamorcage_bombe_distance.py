#python3.6.3

def getDizaines(nombre):
	nbStr = str(nombre)
	nbLen = len(nbStr)
	
	dizaine = nbStr[nbLen-2]
	dizaine = int(dizaine)

	return dizaine

def getUnite(nombre):
	nbStr = str(nombre)
	nbLen = len(nbStr)
	
	unite = nbStr[-1]
	unite = int(unite)

	return unite



nbFilsTotal = 4200

fils = []

for i in range(1,nbFilsTotal+1):
	if (i%5 == 0) or (i%7 == 0):
		if i < 10:
			fils.append(i)
		else:
			dizaine = getDizaines(i)
			unite = getUnite(i)

			if dizaine <= unite:
				fils.append(i)




filsTemp = []

nbFils = len(fils)

for i in range(nbFils):
	if i < (nbFils - 1):
		unite = getUnite(fils[i+1])

		if unite < 5 and fils[i] > 9:
			dizaine = getDizaines(fils[i])

			if dizaine%2 != 0:
				filsTemp.append(fils[i])




nbFilsRestant = len(filsTemp)
middle = int(nbFilsRestant/2)

print("%d,%d" % (filsTemp[middle-1],filsTemp[middle]))
