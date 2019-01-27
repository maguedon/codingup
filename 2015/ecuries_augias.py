#python3.6.3

bleus = []
rouges = []
verts = []

nbSalles = 49
# nbSalles = 10

for i in range(nbSalles):
	if i == 0:
		bleus.append(2)
	elif i%3 == 0:
		litres = rouges[-1] + verts[-1]
		litres = str(litres)[-2:len(str(litres))]
		bleus.append(int(litres))
	elif i%2 == 0:
		litres = bleus[-1] * 5
		verts.append(litres)
	else:
		litres = bleus[-1] * 7
		rouges.append(litres)

print(sum(bleus) + sum(rouges) + sum(verts))