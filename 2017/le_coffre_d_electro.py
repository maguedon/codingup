#python3.6.3

import requests
import urllib3
urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

url = "https://callicode.fr/pydefis/UrlElectro/code/03fCF23cfE"
coffre = False
code = ""

while not coffre:

	# Récupération du contenu de la page
	request = requests.get(url, verify=False)
	elements = request.text.split(" ")

	# Récupération de l'url contenue dans la page
	url = ""
	for i in range(len(elements)):
		if 'https' in elements[i]:
			url = elements[i]
	
	# Récupération du code du coffre
	if not url:
		coffre = True
		code = elements[-1]

print(code)