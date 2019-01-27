#python3.6.3

a = 7
b = 11
c = 13
nbSacs = 20
poidsConsomme = 131
nbJuments = 4

poidsTotal = poidsConsomme * nbJuments

x = 0
y = 0
z = 0

for i in range(1, nbSacs+1):
	for j in range(1, nbSacs+1):
		for k in range(1, nbSacs+1):
			if a*i + b*j + c*k == poidsTotal:
				nbSacsTot = x + y + z
				nbSacsCourant = i + j + k

				if (x == 0 and y == 0 and z == 0) or (nbSacsCourant < nbSacsTot) or ((nbSacsCourant == nbSacsTot) and ((k < z) or (k == z and y < j))):
					x = i
					y = j
					z = k

print(x,y,z)