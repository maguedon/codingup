# coding: utf-8
# python 3.10.3

import io

code = [
    ("←←", u"h"),
    ("←↑", u"!"),
    ("←→", u"m"),
    ("←↓", u"l"),
    ("←A", u"s"),
    ("←B", u","),
    ("↑←", u"r"),
    ("↑↑", u"p"),
    ("↑→", u"x"),
    ("↑↓", u"b"),
    ("↑A", u"j"),
    ("↑B", u"v"),
    ("→←", u"a"),
    ("→↑", u"i"),
    ("→→", u" "),
    ("→↓", u"w"),
    ("→A", u"g"),
    ("→B", u"e"),
    ("↓←", u"e"),
    ("↓↑", u"t"),
    ("↓→", u"."),
    ("↓↓", u"o"),
    ("↓A", u"n"),
    ("↓B", u"u"),
    ("A←", u"a"),
    ("A↑", u"?"),
    ("A→", u"y"),
    ("A↓", u"c"),
    ("AA", u"f"),
    ("AB", u"d"),
    ("B←", u"q"),
    ("B↑", u"k"),
    ("B→", u"'"),
    ("B↓", u"z"),
    ("BA", u"e"),
    ("BB", u"e")
]

def get_value(symbol):
    for item in code:
        if item[0] == symbol:
            return item[1]
    return ""

with io.open('konami.txt', 'r', encoding='utf8') as f:
    file = f.read()

    text = ""

    i = 0
    while i < len(file)-1:
        tmp = file[i] + file[i+1]
        text += get_value(tmp)

        i += 2

    print(text)