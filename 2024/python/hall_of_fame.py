text = "UHMRLJQHC-QRXV"
print(ord('A'))
print(ord('Z'))
sum = 0
for c in text:
    if (c != '-'):
        sum += ord(c) - 65

print(sum)