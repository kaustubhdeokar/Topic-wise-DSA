def to_code(c):
    return ord(c)
with open("ride.in","r") as input_file:
    raw_lines = input_file.readlines()
    lines = map(lambda s:s.strip(),raw_lines)
    lines_to_code = map(to_code,lines)
    for i in lines_to_code:
        print(i)
