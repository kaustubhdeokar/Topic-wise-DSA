import re
for _ in range(int(input())):
    s = input()
    output = re.sub(r'party','pawri',s)
    print(output)
