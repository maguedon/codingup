import requests
import base64
import io

from PIL import Image

def is_white(pix):
    return pix[0] == 255 and pix[1] == 255 and pix[2] == 255

def get_edges(im, x, y):
    edges = []
    width, height = im.size

    if x > 0:
        edges.append((x-1, y))
    if y > 0:
        edges.append((x, y-1))
    if x < width:
        edges.append((x+1, y))
    if y < height:
        edges.append((x, y+1))

    return edges

def set_couleur(x, y, couleur, matrix, couleurs):
    pixel = im.getpixel((x, y))
    if is_white(pixel):
        matrix[x][y] = 0
    else:
        matrix[x][y] = couleur
        couleurs[couleur] += 1

        edges = get_edges(im, x,y)

        for edge in edges:
            value = matrix[edge[0]][edge[1]]
            if value == -1:
                matrix, couleurs = set_couleur(edge[0], edge[1], couleur, matrix, couleurs)

    return (matrix, couleurs)

r = requests.get("https://codingup.univ-poitiers.fr/brilliant/defis/C23_FilsDuTemps/get/Jollymah/7007d", verify=True)
print(r) # Pour contrôle
data = r.json()
print(data['image']) # Pour contrôle

msg = base64.b64decode(data['image'])
buf = io.BytesIO(msg)

im = Image.open(buf)
# im = Image.open("filtemps_01.png")
# im.show()

px = im.load()

width, height = im.size

matrix = [[-1 for _ in range(width)] for _ in range(height)]
nb_lines = 0
couleurs = {}

for x in range(width):
    for y in range(height):
        pixel = im.getpixel((x, y))
        
        if matrix[x][y] == -1:
            pixel = im.getpixel((x, y))
            if is_white(pixel):
                matrix[x][y] = 0
            else:
                nb_lines += 1
                couleurs[nb_lines] = 0
                matrix, couleurs = set_couleur(x, y, nb_lines, matrix, couleurs)

print(matrix)
print(couleurs)

nbPixelsMax = max(couleurs.values())
print(nbPixelsMax)


reponse = {'signature': data['signature'], 'n': nb_lines, 'taille': nbPixelsMax}
print(reponse)
r = requests.post("https://codingup.univ-poitiers.fr/brilliant/defis/C23_FilsDuTemps/post/Jollymah/7007d", json=reponse, verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle