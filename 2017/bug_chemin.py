import math

def getCoord(chemin):
	direction = "N"

	x = 0
	y = 0

	for char in chemin:
		if char == "A":
			if direction == "N":
				y += 100
			if direction == "S":
				y -= 100
			if direction == "E":
				x += 100
			if direction == "O":
				x -= 100

		elif char == "D":
			if direction == "N":
				direction = "E"
			elif direction == "S":
				direction = "O"
			elif direction == "E":
				direction = "S"
			elif direction == "O":
				direction = "N"

		elif char == "G":
			if direction == "N":
				direction = "O"
			elif direction == "S":
				direction = "E"
			elif direction == "E":
				direction = "N"
			elif direction == "O":
				direction = "S"

	return (x,y)

def getDistance(coord):
	x = coord[0]
	y = coord[1]

	distance = math.sqrt(x*x + y*y)
	distance = round(distance, 0)

	return distance




# chemin = "AGGAA"
chemin = "ADDGAGDGGDDADDDGDADADGGGGGADGGDADAADAGGGDDADAAADGDDDDDAAAADDDDDDAGGAAAGGDAGAGADAADADAGDDDAAGGDGGAGAGDAGDGGDGAAGADGAAGDDADGDGDDGADAGAGDAGDAGDDDDGGDGGDAADDGGDAGADADGDDADAADDDAAAGGDGDGGGGADAGDGGGGADDDDDGDDDGAADGGDAAAAGDDDDADGADAGDAGDGAGAGGAADAGADADGGDADGGGGGGAGGDAGADGGADDGDAADGDGDDGDADADDDGAGGDDAGDDAAAGGAADDDGGGAAADGAGDGGAAAGAGAGGDAAAAGADDDDGAADADGDAGAAGGAADGADAGGDGAAAGGGDDAGDDDGADAAAGGAADAAADAAAGAGDDDDGAGGGGGDGGADAGAGAGAAGADADADGAGGDDGAAGGAADDDAGAAADADGAADADGGGAGAGDGGDAGDAGDGGAGGGADDDGDGAGGADDGDGA"

i = 0

coordList = set()
maxDistance = 0

for char in chemin:
	if char == "A":
		newChemin1 = chemin[:i] + "G" + chemin[i+1:]
		newChemin2 = chemin[:i] + "D" + chemin[i+1:]
	elif char == "D":
		newChemin1 = chemin[:i] + "G" + chemin[i+1:]
		newChemin2 = chemin[:i] + "A" + chemin[i+1:]
	elif char == "G":
		newChemin1 = chemin[:i] + "D" + chemin[i+1:]
		newChemin2 = chemin[:i] + "A" + chemin[i+1:]

	coord1 = getCoord(newChemin1)
	coordList.add(coord1)
	distance1 = getDistance(coord1)
	# print(newChemin1)
	if (distance1 > maxDistance):
		maxDistance = distance1

	coord2 = getCoord(newChemin2)
	coordList.add(coord2)
	distance2 = getDistance(coord2)
	# print(newChemin2)
	if (distance2 > maxDistance):
		maxDistance = distance2


	i = i + 1

# print(coordList)
print(len(coordList))
print(maxDistance)