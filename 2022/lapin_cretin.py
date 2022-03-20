# python 3.10.3

with open('lapin_cretin.txt', 'r') as f:
    file = f.read()

i = 1

text = ""

while i < (len(file) - 4):
    if (file[i]+file[i+1]+file[i+2]) == "BWA":
        i += 5
    else:
        text += file[i]
        i += 1

print(text)