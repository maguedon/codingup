from PIL import Image

import binascii

im = Image.open("message_cache.png")

px = im.load()

pixels = list(im.getdata())
width, height = im.size

pixels = [pixels[i * width:(i + 1) * width] for i in range(height)]

message = ""

for x in range(height):
	for y in range(width):
		pixel = pixels[x][y]

		r = pixel[0]
		g = pixel[1]
		b = pixel[2]

		pixBinR = bin(r)[-1:]
		pixBinG = bin(g)[-1:]
		pixBinB = bin(b)[-1:]

		message += pixBinR
		message += pixBinG
		message += pixBinB


messageStr = ""
while message != "":
    i = chr(int(message[:8], 2))
    messageStr = messageStr + i
    message = message[8:]

print(messageStr)