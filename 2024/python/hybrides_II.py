def getBinary(nb):
    return bin(nb)[2:]

def sumIsOk(sum, obj):
    x = 0
    while x < len(sum) and int(sum[x]) >= int(obj[x]):
        x += 1

    return x == len(sum)

# mat = [58, 50, 42, 35, 67]
mat = [17410, 16384, 11488, 8192, 6146, 5120, 4609, 4133, 4100, 4096, 3072, 2064, 2048, 1552, 1024, 644, 576, 520, 512, 264, 258, 256, 128, 64, 40, 32, 16, 8, 4, 2, 1]
# obj = '0111021'
obj = '110222021001120'

# bin = getBinary(58)
# binInt = int(bin)

# print(bin)
# print(str(binInt).zfill(2))



def getSum(nb, list):
    binInt1 = int(nb)

    for i in range(len(list)):
        binInt2 = int(list[i])

        sum = str(binInt1 + binInt2).zfill(max(len(str(binInt1)), len(str(binInt2))))

        if(sumIsOk(sum, obj)):
            return [list[i]]
        else:
            if len(list) == 1:
                return None
            else:
                res = getSum(sum, list[1::])
                if res != None:
                    return res.append(nb)
    return None





bins = list(map(getBinary, mat))
bins = list(map(zfill(2), bins)))
print(bins)


# print(getSum(0, bins))

# ok = False
# i = 0
# while i < len(bins) and not ok:
#     numbersList = [mat[i]]
#     binInt1 = int(bins[i])

#     j = i+1
#     while j < len(bins) and not ok:
#         numbersList.append(mat[j])
#         binInt2 = int(bins[j])

#         sum = str(binInt1 + binInt2).zfill(7)

#         if sumIsOk(sum, obj):
#             ok = True
#         else:
#             k = j+1
#             while k < len(bins) and not ok:
#                 numbersList.append(mat[k])
#                 binInt3 = int(bins[k])

#                 sum = str(binInt1 + binInt2 + binInt3).zfill(7)

#                 if sumIsOk(sum, obj):
#                     ok = True
#                 else:
#                     numbersList.pop()
                
#                 k+=1

#         if not ok:
#             numbersList.pop()

#         j += 1
#     i += 1
#     print(numbersList)