# x2 = (x1      + 2 * y1) % 2018
# y2 = (-3 * x1 +     y1) % 2018

x1 = 1694
y1 = 1546

nbIterations = 50

for i in range(1,nbIterations+1):
	x = (x1 + 2*y1) % 2018
	y = (-3*x1 + y1) % 2018

	x1 = x
	y1 = y

print(x1,y1)

declinaison      = (x1 - 900)  / 10
ascension = (y1 / 150) * 2

print(declinaison, ascension)