from PIL import Image

def inverse(a):
	return a[::-1]

def getInverse(a):
	b = "{0:b}".format(a)
	if len(b) < 8:
		for i in (0, 8 - len(b)):
			b = '0' + b

	inverseNb = inverse(b)

	return int(inverseNb,2)



im = Image.open("portrait_colore.png")

px = im.load()

pixels = list(im.getdata())
width, height = im.size

pixels = [pixels[i * width:(i + 1) * width] for i in range(height)]

for x in range(height):
	for y in range(width):
		pixel = pixels[x][y]

		r = pixel[0]
		g = pixel[1]
		b = pixel[2]


		rI = getInverse(r)
		gI = getInverse(g)
		bI = getInverse(b)

		px[y,x] = (rI,gI,bI)
		# im.putpixel((y,x), (r,g,b))

im.save("new_image.png")
im.show()

