#python3.7.2

entree = [746, 157, 382, 461, 885, 638, 462, 390, 581, 692]

retour = []

for nb in entree:
	etapes = 0

	while str(nb) != str(nb)[::-1] and etapes <= 100:
		nb = nb + int(str(nb)[::-1])
		etapes = etapes + 1

	retour.append([nb, etapes])

print(retour)