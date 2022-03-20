# python 3.10.3

from defisurl import DefisUrl

d = DefisUrl('https://codingup.univ-poitiers.fr/herewego/defis/ExempleURL/get/Jollymah/3602e', verify=True)
lignes = d.get()

print(lignes)
res = int(lignes[0])+int(lignes[1])
print(res)

rep = d.post(res)
print(rep)