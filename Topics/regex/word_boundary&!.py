import re

texttosearch='Ha HaHa'
pattern=re.compile(r'\bHa')
#the Ha's which appear after a word boundary.
pattern1=re.compile(r'\BHa')
#the Ha's which do not appear after a word boundary.
matches=pattern.finditer(texttosearch)

start,end=0,0
for i in matches:
    print(i)