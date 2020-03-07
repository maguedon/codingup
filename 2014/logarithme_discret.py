# https://callicode.fr/pydefis/LogDiscret/txt
# python 3.8

import math

bi = [28, 134, 36, 101, 39, 42, 57, 75, 192, 41]
xi = []

for b in bi:
	x = 0
	while (((3 ** x) % 223) != b):
		x += 1

	xi.append(x)

print(xi)