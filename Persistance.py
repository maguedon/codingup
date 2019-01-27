#python3.7.2

n1 = 1701
n2 = 4581

chiffres = {
	'1': 0,
	'2': 0,
	'3': 0,
	'4': 0,
	'5': 0,
	'6': 0,
	'7': 0,
	'8': 0,
	'9': 0,
}

for i in range(n1, n2 + 1):
	strN = str(i)
	number = i

	while len(strN) > 1:
		temp = 1
		for x in strN:
			temp = temp * int(x)

		strN = str(temp)

	if (strN != "0"):
		chiffres[strN] = chiffres[strN] + 1

print(chiffres)
