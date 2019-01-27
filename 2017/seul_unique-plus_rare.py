#python3.6.3

from defisurl import *

# d = DefisUrl('https://callicode.fr/pydefis/PokePlusRare/input') #Le Seul et l'unique
d = DefisUrl('https://callicode.fr/pydefis/PokePlusRare2/input') # Le plus rare
lignes = d.get()

occurences = {}
pokemons = {}

for ligne in lignes:
	pokemon = ligne.split(',')

	if pokemon[0] in occurences:
		occurences[pokemon[0]] += 1
	else:
		occurences[pokemon[0]] = 1

	pokemons[pokemon[0]] = (pokemon[1], pokemon[2])

occurences = sorted(occurences, key=occurences.get)

unique = occurences[0]

print(pokemons[unique])