class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        l = len(grid)
        s = set(range(1, l*l+1))
        double,missing=-1,-1
        for row in grid:
            for i in row:
                try:
                    s.remove(i)
                except KeyError as k:
                    double = k.args[0]
        for i in iter(s):
            missing = i
        return [double, missing]
