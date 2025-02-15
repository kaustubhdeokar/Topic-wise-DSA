class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        s = 0
        e = len(nums) - 1
        if(len(nums)==1):
            return 0


        return self.findPeak(nums, s, e)

    def findPeak(self, nums: List[int], s, e) -> int:
        while s <= e:
            m = s + (e-s)//2
            print(f's={s}, m={m}, e={e}')

            if nums[m-1] <= nums[m] and nums[m] >= nums[(m+1)%len(nums)]:
                return m
            greater = 'left' if nums[m-1] > nums[(m+1)%len(nums)] else 'right'
            if greater == 'right': # move right
                return self.findPeak(nums, m+1, e)
            else:
                return self.findPeak(nums, s, m -1)
        return -1
