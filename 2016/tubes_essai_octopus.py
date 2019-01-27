#python3.6.3

nbMelanges = 50
# nbMelanges = 2

nbTubesTotal = 65
# nbTubesTotal = 9

numTas = [14, 14, 14, 23]
# numTas = [2, 2, 2, 3]

ordreMelanges = [3, 0, 2, 1]

# Initialisation tableau correspondant aux tubes
# avec un 'X' indiquant les tubes empoisonnés
tubes = []

for i in range(nbTubesTotal):
	if (i+1)%2 == 0:
		tubes.append('')
	else:
		tubes.append('X');

# Mélange des tubes
tubesTemp = []

for k in range(nbMelanges):
	for i in range(len(ordreMelanges)):
		num = ordreMelanges[i]
		nbTubes = numTas[num]
		for j in range(nbTubes):
			tubesTemp.append(tubes[14*num+j])

	tubes = tubesTemp
	tubesTemp = []
	

# Récpération des tubes non empoisonnés
tubesFinaux = []

for i in range(nbTubesTotal):
	if tubes[i] != 'X':
		tubesFinaux.append(str(i+1))


print(','.join(tubesFinaux))