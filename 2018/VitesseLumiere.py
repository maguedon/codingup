#python3.7.2

x = 147
y = 440
z = 659

while 10 * x > y :
    x = (y * z) % 10000
    y = (3 * z) % 10000
    z = (7 * z) % 10000

print(x,y,z)