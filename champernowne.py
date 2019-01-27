#python3.7.2

n1 = 104
n2 = 156

constChamp = ""

for i in range(1,n2):
	constChamp = constChamp + str(i)

somme = 0

for i in range(n1-1, n2):
	somme = somme + int(constChamp[i])

print(somme)