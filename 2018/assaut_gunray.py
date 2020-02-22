porte = 70
v = 0
e = 0
eTotale = 0
nbSecondes = 0
moitie = False

while eTotale < porte:
	nbSecondes += 1
	e = 3 - (0.005 * v)
	eTotale += e
	v = v + (8 * e)

	if (not moitie and eTotale >= (porte/2)):
		moitie = True
		print(nbSecondes)

print(nbSecondes)