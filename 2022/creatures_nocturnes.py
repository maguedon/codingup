# python 3.10.3

nb_creatures = 0
nb_chauves_souris = 0
nb_skellingtons = 0
nb_zombies = 0
nb_fantomes = 0

total_time = 50 * 60

nb_creatures_killed = [2, 1, 1, 1]

for i in range(1, total_time+1):
    if i%2 == 0:
        nb_chauves_souris += 10
    if i%5 == 0:
        nb_skellingtons += 5
    if i%6 == 0:
        nb_zombies += 4
    if i%10 == 0:
        nb_fantomes += 3

    if i%6 == 0:
        nb_chauves_souris -= nb_creatures_killed[0]
    if i%20 == 0:
        nb_skellingtons -= nb_creatures_killed[1]
    if i%30 == 0:
        nb_zombies -= nb_creatures_killed[2]
    if i%40 == 0:
        nb_fantomes -= nb_creatures_killed[3]

    if i%(4*60) == 0:
        nb_creatures_killed[0] += 2
        nb_creatures_killed[1] += 1
        nb_creatures_killed[2] += 1
        nb_creatures_killed[3] += 1

    
print(nb_chauves_souris, nb_skellingtons, nb_zombies, nb_fantomes)