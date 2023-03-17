#python3.7.2

tour = 32400 #cm

x = 1370 #cm
y = 280 #cm

jours = 0

avancee = 0

last = 0

while avancee < tour:
	avancee = avancee + x

	if avancee >= tour:
		break

	avancee = avancee - y

	if (jours+3)%8 == 0:
		last = avancee

	if (jours+1)%8 == 0:
		avancee = last

	print(jours, avancee)

	x = x - 1
	jours = jours + 1


print(jours)