import math

u = 37
n = 26

for i in range(n):
	uBin = bin(u)
	oneOccurences = uBin.count('1')
	oneOccurencesBin = bin(oneOccurences)
	finalBin = uBin + oneOccurencesBin[2:]
	u = int(finalBin, 2)

print(u)


# 128	64	32	16	8	4	2	1
# 1	0	0	1	0	1	1	1	0

# 52875390419085124181172516608447111782048972