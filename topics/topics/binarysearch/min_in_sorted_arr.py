class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1: return nums[0]
        if len(nums)==2: return min(nums[0], nums[1])
        s = 0
        e = len(nums)-1
        smallest = 5001

        while s <= e:
            m = s + (e-s)//2
            if s == e:
                smallest = min(smallest, nums[s])
                break
            elif nums[s] <= nums[m]: # left half sorted
                print('left half sorted')
                smallest = min(smallest, nums[s])
                s = m + 1
            else:
                print('right half sorted')
                smallest = min(smallest, nums[m])
                e = m - 1
            print(f's = {s}, m = {m} , e = {e}')
        return smallest

