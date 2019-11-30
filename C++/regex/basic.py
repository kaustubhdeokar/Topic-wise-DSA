import re

texttosearch="aaabcdedeg"
p=re.compile(r'[a-z]')
pattern=re.compile(r'([0-9]|[aA-zZ])\1\1')

matches=p.finditer(texttosearch)
matches=tuple(matches)
print(len(matches))


