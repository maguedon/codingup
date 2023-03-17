#python3.6.3

from defisurl import *

# Connexion au défi et récupération des entrées
d = DefisUrl('https://callicode.fr/pydefis/ExempleURL/get/JollyMah/65605') # Mettez votre URL personnalisée ici
lignes = d.get()

# Affichage pour contrôle :
print(lignes)

res = 0;

for i in lignes:
	if i:
		res += int(i)

# Affichage de la réponse pour contrôle et envoi :
print(res)
rep = d.post(res)
print(rep)