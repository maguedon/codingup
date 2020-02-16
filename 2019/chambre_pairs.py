sequence = ""
maxSequence = ""
maxLen = 0
pairChars = ('A', 'M', 'E', 'L', 'I', 'R', 'N', 'O', 'P', 'S', 'U', 'W', 'T', '/', '0', '2', '4', '6', '8')

with open('chambre_pairs.txt', 'r', encoding='utf8') as f:
	for line in f:
		for ch in line:
			ch = ch.upper()

			if ch in pairChars:
				sequence = sequence + ch
			else:
				if len(sequence) > maxLen:
					maxLen = len(sequence)
					maxSequence = sequence

				sequence = ""

print (maxSequence)
print (maxLen)
