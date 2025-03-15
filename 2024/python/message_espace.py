def isSequenceRare(sequence):
    for i in range(len(sequence)-1):
        char = sequence[i]
        if i < len(sequence) - 1 and char == sequence[i+1]:
            return False
        if i < len(sequence) - 2 and char == sequence[i+2]:
            return False            
        if i < len(sequence) - 3 and char == sequence[i+3]:
            return False
    return True

def getNbLignesRares(fileName):
    with open(fileName, 'r') as f:
        file = f.read()

        lines = file.split('\n')
        nbSequencesRares = 0

        for i in range(len(lines)):
            if isSequenceRare(lines[i]):
                nbSequencesRares += 1

        return nbSequencesRares


enregistrementsSuspects = []

for i in range(1, 501):
    nbStr = str(i).zfill(3)

    nbLignesRares = getNbLignesRares('radio_enregistrements/enreg'+nbStr+'.txt')

    if (nbLignesRares < 172 or nbLignesRares > 235):
        enregistrementsSuspects.append(i)

print(enregistrementsSuspects)