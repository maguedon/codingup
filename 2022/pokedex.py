# python 3.10.3

with open('pokedex.txt', 'r') as f:
    file = f.read()
    nombres = file.split(", ")

nombres = [int(num) for num in nombres]

nombres = sorted(nombres)

print(nombres)

res = ""

for ind in range(len(nombres)):
    if ind == 0:
        res += str(nombres[ind])
    else:
        if nombres[ind] > nombres[ind-1] + 1:
            res += ", " + str(nombres[ind])

        if (nombres[ind] == nombres[ind-1] + 1) and (nombres[ind] < nombres[ind+1] - 1):
            res += "-" + str(nombres[ind])

print(res)