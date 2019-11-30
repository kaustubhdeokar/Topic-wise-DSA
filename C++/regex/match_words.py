import re

texttosearch='Today is 27th June 2019'
pattern=re.compile(r'\b(\w)+\b')

matches=pattern.finditer(texttosearch)

start,end=0,0
for i in matches:
    print(i)