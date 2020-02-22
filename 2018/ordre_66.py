def containsOnlyEvenNumbers(number):
	strNumber = str(number)

	containsOnlyEvenNumbers = True

	for x in strNumber:
		if (int(x)%2 == 0):
			containsOnlyEvenNumbers = False
			break;
	
	return containsOnlyEvenNumbers

def containsOnlyOddNumbers(number):
	strNumber = str(number)

	containsOnlyOddNumbers = True
	
	for x in strNumber:
		if (int(x)%2 != 0):
			containsOnlyOddNumbers = False
			break;

	return containsOnlyOddNumbers

for i in range(1111, 9999):
	strI = str(i)
	if (containsOnlyEvenNumbers(i)):
		if (strI[0] < strI[1] and strI[1] < strI[2] and strI[2] < strI[3]):
			produit = int(strI[0]) * int(strI[1]) * int(strI[2]) * int(strI[3])

			if (containsOnlyEvenNumbers(produit)):
				somme = int(strI[0]) + int(strI[1]) + int(strI[2]) + int(strI[3])

				if (containsOnlyOddNumbers(somme)):
					print(i)
					break;

