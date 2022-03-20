# python 3.10.3

import math
import datetime

def calcul_distance(data1, data2):
    data1 = [float(num) for num in data1[:-1]]
    data2 = [float(num) for num in data2[:-1]]
    (lat1, long1, alt1) = data1
    (lat2, long2, alt2) = data2

    print(data1, data2)

    lat1 = math.radians(lat1)
    lat2 = math.radians(lat2)

    long1 = math.radians(long1)
    long2 = math.radians(long2)

    dist_lat = lat1 - lat2
    dist_long = long1 - long2

    a =  (math.sin(dist_lat / 2) ** 2) + (math.cos(lat1) * math.cos(lat2) * (math.sin(dist_long / 2) ** 2))
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    d = 6371 * 1000 * c

    height = alt1 - alt2

    print(math.sqrt(math.pow(d, 2) + math.pow(height, 2)))

    return math.sqrt(math.pow(d, 2) + math.pow(height, 2))

def calcul_time(t1, t2):
    t1_split = t1.split(":")
    t1_split = [int(num) for num in t1_split]
    t1_time = datetime.datetime(2022, 3, 20, t1_split[0], t1_split[1], t1_split[2])

    t2_split = t2.split(":")
    t2_split = [int(num) for num in t2_split]
    t2_time = datetime.datetime(2022, 3, 20, t2_split[0], t2_split[1], t2_split[2])

    return (t1_time - t2_time).total_seconds()

with open('mario_sports_hiver.txt', 'r') as f:
# with open('mario_exemple.txt', 'r') as f:
    file = f.read()
    lignes = file.split("\n")

list_descentes = []
prev = []
descente = 0

total_descente = 0
total_time = 0

for ligne in lignes:
    if len(ligne) > 0:
        data = ligne.split(" ")
        if len(prev) > 0:
            if prev[2] > data[2]:
                descente = 1
            elif prev[2] < data[2]:
                descente = 0

            if descente:
                distance = calcul_distance(prev, data)
                temps = calcul_time(data[3], prev[3])
                total_descente += distance
                total_time += temps

        prev = data

print(total_descente, total_time, total_descente / total_time)
