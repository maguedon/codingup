# python 3.10.3

with open('hen_llinge.txt', 'r') as f:
    file = f.read()

i = 0

text = ""
change = 1

while change == 1:
    change = 0
    i = 0
    while i < len(file) - 1:
        if file[i].islower() and file[i].upper() == file[i+1]:
            i += 2
            change = 1
        else:
            text += file[i]
            i += 1


    if i != len(file):
        text += file[len(file)-1]
    print(text)

    file = text
    text = ""

print(text)

