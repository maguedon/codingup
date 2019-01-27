#python3.7.2

entree = [77, 94, 80, 67, 37, 53, 61, 53, 59, 3, 92, 17, 44, 11, 13, 75, 93, 98, 91, 9]

pieces = {
	50: 0,
	20: 0,
	10: 0,
	5: 0,
	2: 0,
	1: 0
}

for i in entree:
	nb = i
	while nb > 0:
		if nb >= 50:
			nb = nb - 50
			pieces[50] = pieces[50] + 1
		elif nb >= 20:
			nb = nb - 20
			pieces[20] = pieces[20] + 1
		elif nb >= 10:
			nb = nb - 10
			pieces[10] = pieces[10] + 1
		elif nb >= 5:
			nb = nb - 5
			pieces[5] = pieces[5] + 1
		elif nb >= 2:
			nb = nb - 2
			pieces[2] = pieces[2] + 1
		elif nb >= 1:
			nb = nb - 1
			pieces[1] = pieces[1] + 1

print(pieces)
