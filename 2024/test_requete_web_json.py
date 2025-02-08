import requests

r = requests.get("https://codingup.univ-poitiers.fr/outthere/defis/SampleJson2024/get/Jollymah/5af61", verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle
reponse = {'signature': data['signature'], 'c': data['a'] + data['b']}
r = requests.post("https://codingup.univ-poitiers.fr/outthere/defis/SampleJson2024/post/Jollymah/5af61", json=reponse, verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle