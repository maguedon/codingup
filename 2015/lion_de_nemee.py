#python3.6.3

import string

divinites = "ARTEMIS ASCLEPIOS ATHENA ATLAS CHARON CHIRON CRONOS DEMETER EOS ERIS EROS GAIA HADES HECATE HEPHAISTOS HERA HERMES HESTIA HYGIE LETO MAIA METIS MNEMOSYNE NYX OCEANOS OURANOS PAN PERSEPHONE POSEIDON RHADAMANTHE SELENE THEMIS THETIS TRITON ZEUS"

listeDivinite = divinites.split(' ')

listeFinale = {}

for divinite in listeDivinite:
	somme = 0
	for char in divinite:
		char = char.lower()
		somme += string.ascii_lowercase.index(char) + 1

	listeFinale[divinite] = somme

listeFinale = sorted(listeFinale, key=listeFinale.get)

print(' '.join(listeFinale))