#python3.7.2

# q(n-q(n-1)) + q(n-q(n-2))

i = 2313
j = 2374

somme = 0
n = 3

q = {}

q[1] = 1
q[2] = 1

while n <= j:
	qn = q[n - q[n-1]] + q[n - q[n-2]]

	if n >= i:
		somme = somme + qn

	q[n] = qn

	n = n + 1

print(somme)