class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        s = 0
        e = len(nums)-1

        while s <= e:
            m = s + (e-s)//2
            # print(f'm = {m} s = {s}, e = {e}')
            if nums[m] == target:
                return True

            elif nums[s] == nums[e]: ## to handle duplicates
                if(nums[s]==target):
                    return True
                else:
                    s+=1
                    e-=1

            # left half is sorted
            elif nums[s] <= nums[m]:
                # if finding for 1
                # biggest number smaller, smallest number bigger
                if nums[m] < target or nums[s] > target:
                    s = m + 1
                else:
                    e = m -1
                # print(f's = {s}, e = {e}')
            # right half sorted.
            elif nums[m] <= nums[e]:
                # smallest number bigger or biggest number smaller than target
                if nums[m] > target or nums[e] < target:
                    e = m -1
                else:
                    s = m + 1
                # print(f's = {s}, e = {e}')

        return False


if __name__ == "__main__":
    s = Solution()
    res = s.search([2,5,6,0,0,1,2], 1)
    res = s.search([2,5,6,0,0,1,2], 3)
    res = s.search([1,2,1], 1)

# 2 5 5 1 2