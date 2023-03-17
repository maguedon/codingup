#python3.7.2

suite = ""

u = 2903
n = 167

for x in range(n-1):
	u = str(u)
	if len(u) < 4:
		for i in range(4-len(u)):
			u = "0" + u

	u = int(u[:2]) + int(u[-2:])
	u = u * 191 + 161
	u = u%9973

print(u)