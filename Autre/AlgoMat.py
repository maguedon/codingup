#python3.7.2

matrice = [
	[36, 19, 27, 36, 7, 10],
	[2, 18, 3, 33, 2, 21],
	[26, 27, 4, 22, 30, 31],
	[29, 36, 7, 20, 6, 30],
	[30, 6, 14, 23, 15, 13],
	[22, 10, 10, 35, 15, 22]
]

etapes = 23

somme = 0

for i in range(etapes):
	for x in range(len(matrice)):
		ligne = matrice[x]
		for y in range(len(ligne)):
			cellule = ligne[y]

			newVal = (11 * cellule + 4)%37

			ligne[y] = newVal

			if i == (etapes - 1):
				somme = somme + newVal


print(somme)				

