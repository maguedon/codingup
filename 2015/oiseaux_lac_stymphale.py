from PIL import Image

im = Image.open("oiseaux_lac_stymphale.png")

px = im.load()

pixels = list(im.getdata())
width, height = im.size

nbOiseaux = sum(pixels)

print(nbOiseaux)
