import requests
import base64
from PIL import Image

def convertir(symbole):
    switch = {
        'a': 'BBB',
        'd': 'BBN',
        'c': 'BBR',
        'b': 'BBV',
        'i': 'BRB',
        'l': 'BRN',
        'k': 'BRR',
        'j': 'BRV',
        'e': 'BVB',
        'h': 'BVN',
        'g': 'BVR',
        'f': 'BVV',
        'm': 'VBB',
        'p': 'VBN',
        'o': 'VBR',
        'n': 'VBV',
        'u': 'VRB',
        'x': 'VRN',
        'w': 'VRR',
        'v': 'VRV',
        'q': 'VVB',
        't': 'VVN',
        's': 'VVR',
        'r': 'VVV',
        'Majuscule': 'NBB',
        ',': 'NBN',
        '.': 'NBR',
        ' ': 'NBV',
        ')': 'NRB',
        '#': 'NRN',
        '/': 'NRR',
        '?': 'NRV',
        ':': 'NVB',
        '(': 'NVN',
        '-': 'NVR',
        '\'': 'NVV',
        'y': 'RBB',
        '1': 'RBN',
        '0': 'RBR',
        'z': 'RBV',
        '6': 'RRB',
        '9': 'RRN',
        '8': 'RRR',
        '7': 'RRV',
        '2': 'RVB',
        '5': 'RVN',
        '4': 'RVR',
        '3': 'RVV'
    }

    return switch.get(symbole,"Invalid input")

def getColor(symbole):
    if (symbole == 'N'):
        return (0,0,0)
    if (symbole == 'R'):
        return (255,0,0)
    if (symbole == 'V'):
        return (0,255,0)
    return (0,0,255)



text = 'Assassination case - #1 (JFK)'
im = Image.new(mode="RGB", size=(158, 25))

for y in range(25):
    im.putpixel((0, y), getColor('N'))
    im.putpixel((1, y), getColor('R'))
    im.putpixel((2, y), getColor('V'))
    im.putpixel((3, y), getColor('B'))

cpt = 4

for i in range(len(text)):
    char = text[i]
    if char.upper() != char:
        symbole = convertir('Majuscule')
        for x in range(3):
            for y in range(25):
                im.putpixel((cpt+x, y), getColor(symbole[x]))
        cpt += 3
    symbole = convertir(char.lower())
    for x in range(3):
        for y in range(25):
            im.putpixel((cpt+x, y), getColor(symbole[x]))
    cpt+=3

symboleEspace = convertir(' ')

while cpt < 158-4:
    for y in range(25):
        im.putpixel((cpt, y), getColor(symboleEspace[0]))
        im.putpixel((cpt+1, y), getColor(symboleEspace[1]))
        im.putpixel((cpt+2, y), getColor(symboleEspace[2]))

    cpt += 3
    
for y in range(25):
    im.putpixel((154, y), getColor('N'))
    im.putpixel((155, y), getColor('R'))
    im.putpixel((156, y), getColor('V'))
    im.putpixel((157, y), getColor('B'))

im.show()


# r = requests.get("https://codingup.univ-poitiers.fr/outthere/defis/C24_CodeBarre2/get/Jollymah/843ad", verify=True)
# data = r.json()

# reponse = {'signature': data['signature']}



# print(reponse)

# r = requests.post("https://codingup.univ-poitiers.fr/outthere/defis/C24_CodeBarre2/post/Jollymah/843ad", json=reponse, verify=True)
# print(r) # Pour contrôle
# data = r.json()
# print(data) # Pour contrôle