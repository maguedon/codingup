import requests

exemple = [
    [15, 10, 13, 13, 17, 19, 13, 15, 12, 14],
    [17, 16, 18, 18, 11, 16, 17, 17, 18, 11],
    [15, 19, 18, 19, 14, 13, 10, 13, 15, 10],
    [12, 13, 18, 11, 13, 13, 13, 17, 10, 11],
    [19, 19, 10, 14, 17, 13, 12, 17, 12, 10],
    [10, 14, 15, 15, 16, 18, 14, 11, 14, 19],
    [18, 11, 11, 17, 19, 19, 13, 16, 17, 12],
    [10, 13, 15, 19, 14, 14, 16, 14, 14, 13],
    [14, 14, 18, 14, 13, 17, 15, 15, 19, 11],
    [15, 19, 13, 10, 15, 10, 11, 12, 14, 12]
]

def getMin(tableau):
    valMin = -1
    xMin = -1
    yMin = -1

    for i in range(1,len(tableau)-1):
        for j in range(1,len(tableau[i])-1):
            moy = tableau[i-1][j-1] + tableau[i][j-1] + tableau[i+1][j-1]
            moy += tableau[i-1][j] + tableau[i][j] + tableau[i+1][j]
            moy += tableau[i-1][j+1] + tableau[i][j+1] + tableau[i+1][j+1]
            moy /= 9

            if (valMin == -1 or valMin > moy):
                valMin = moy
                xMin = i
                yMin = j

    return [xMin, yMin]


r = requests.get("https://pydefis.callicode.fr/defis/C24_Mimas/get/JollyMah/34649", verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle

reponse = {'signature': data['signature']}

for i in range(1, 11):
    chiffreStr = str(i).zfill(2)
    tableau = data['carte'+chiffreStr]

    reponse['trou'+chiffreStr] = getMin(tableau)

print(reponse)

r = requests.post("https://pydefis.callicode.fr/defis/C24_Mimas/post/JollyMah/34649", json=reponse, verify=True)
print(r) # Pour contrôle
data = r.json()
print(data) # Pour contrôle