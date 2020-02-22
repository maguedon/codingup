numbers = []

for i in range(1, 5000):
	for j in range (1, 5000):
		multiplication = i * j
		multiplication = str(multiplication)

		if (len(multiplication) == 4):
			stringNumber = str(i)+str(j)
			stringNumber = ''.join(sorted(stringNumber))

			stringNumber2 = ''.join(sorted(multiplication))

			if (stringNumber == stringNumber2):
				numbers.append(multiplication)
		elif (len(multiplication) > 4):
			break;

print(numbers)
