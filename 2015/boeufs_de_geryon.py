# total < 1000
# roux + blancs + noirs < 1000
# blancs < roux < noirs < blancs * 2


# roux * blancs * noirs = 777 * (roux + blancs + noirs)
# (roux * blancs * noirs) / (roux + blancs + noirs) = 777

max = 777

for b in range(1, max):
	for r in range(b+1, max):
		for n in range(r+1, max):
			if (b < r) and (r < n) and (n < 2*b) and (r+b+n < 1000) and ((r*b*n)/(r+b+n) == 777):
				print(b,r,n)
				print(b+r+n)