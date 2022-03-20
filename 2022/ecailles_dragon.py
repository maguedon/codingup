# python 3.10.3

from PIL import Image

im = Image.open("dungeons_portal_enc.png")

px = im.load()

width, height = im.size

for x in range(width):
    for y in range(height):
        pixel = im.getpixel((x, y))
        sum = x**3 + y**7

        im.putpixel((x,y), pixel ^ (sum%256))

# im.save("new_image.png")
im.show()

