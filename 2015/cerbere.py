#python3.6.3

from math import sqrt

# y² = 50² - x²

distance = 2925

x = 1
y = sqrt(pow(distance, 2) - pow(x, 2))

res = (0,0)

while x <= y and res == (0,0):
	if float(int(y)) == y:
		res = (x,int(y))

	x += 1
	y = sqrt(pow(distance, 2) - pow(x, 2))

print(res)