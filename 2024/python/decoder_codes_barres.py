import requests
import base64
from PIL import Image

def convertir(symbole):
    switch = {
        'BBB': 'a',
        'BBN': 'd',
        'BBR': 'c',
        'BBV': 'b',
        'BRB': 'i',
        'BRN': 'l',
        'BRR': 'k',
        'BRV': 'j',
        'BVB': 'e',
        'BVN': 'h',
        'BVR': 'g',
        'BVV': 'f',
        'VBB': 'm',
        'VBN': 'p',
        'VBR': 'o',
        'VBV': 'n',
        'VRB': 'u',
        'VRN': 'x',
        'VRR': 'w',
        'VRV': 'v',
        'VVB': 'q',
        'VVN': 't',
        'VVR': 's',
        'VVV': 'r',
        'NBB': 'Majuscule',
        'NBN': ',',
        'NBR': '.',
        'NBV': ' ',
        'NRB': ')',
        'NRN': '#',
        'NRR': '/',
        'NRV': '?',
        'NVB': ':',
        'NVN': '(',
        'NVR': '-',
        'NVV': '\'',
        'RBB': 'y',
        'RBN': '1',
        'RBR': '0',
        'RBV': 'z',
        'RRB': '6',
        'RRN': '9',
        'RRR': '8',
        'RRV': '7',
        'RVB': '2',
        'RVN': '5',
        'RVR': '4',
        'RVV': '3'
    }

    return switch.get(symbole,"Invalid input")

def getColor(pix):
    if (pix[0] == 0 and pix[1] == 0 and pix[2] == 0):
        return 'N'
    if (pix[0] == 255):
        return 'R'
    if (pix[1] == 255):
        return 'V'
    return 'B'

# NRVB = à l'endroit
def traitement(imagePath):
    im = Image.open(imagePath)
    pix = im.load()
    resultat = ''
    majuscule = False

    i = 4
    while (i < 158-7):
        symbole = getColor(pix[i,0]) + getColor(pix[i+1, 0]) + getColor(pix[i+2,0])
        valeur = convertir(symbole)

        if (valeur == 'Majuscule'):
            majuscule = True
        else:
            if majuscule:
                resultat += valeur.upper()
                majuscule = False
            else:
                resultat += valeur

        i += 3
        
    resultat = resultat.strip()

    gardeDebut = getColor(pix[0, 0]) + getColor(pix[1,0]) + getColor(pix[2,0]) + getColor(pix[3,0])
    if (gardeDebut != 'NRVB'):
        resultat = resultat[::-1]
    
    return resultat


r = requests.get("https://pydefis.callicode.fr/defis/C24_CodeBarre1/get/JollyMah/667c8", verify=True)
data = r.json()

reponse = {'signature': data['signature']}

for x in range(1,11):
    codeBarre = data['code-barres'+str(x)]
    with open("codeBarre"+str(x)+".png", "wb") as fh:
        fh.write(base64.decodebytes(str.encode(codeBarre)))
    resultat = traitement("codeBarre"+str(x)+".png")
    reponse['libelle'+str(x)] = resultat

print(reponse)

r = requests.post("https://pydefis.callicode.fr/defis/C24_CodeBarre1/post/JollyMah/667c8", json=reponse, verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle