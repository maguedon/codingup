import requests

r = requests.get("https://codingup.univ-poitiers.fr/brilliant/defis/ExempleJSON/get/Jollymah/3f9ee", verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle


reponse = {'signature': data['signature'], 'c': data['a'] + data['b']}
r = requests.post("https://codingup.univ-poitiers.fr/brilliant/defis/ExempleJSON/post/Jollymah/3f9ee", json=reponse, verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle