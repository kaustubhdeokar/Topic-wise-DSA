class Solution:
    def __init__(self, nums: list[int]):
        self.nums = nums

    # 2 3 4 7 11
    # here brute force O(n) solution is straightforward.
    # to better it we have binary search.
    # idea is to calculate numbers missing before a certain index.
    # for 7 (index = 3) ideally 4 should be on index 3 [1 2 3 4] but now we have 7, so it's 7 - (index+1) = 7 - 4 = 3

    def find_kth_missing_num(self, k):
        start = 0
        end = len(self.nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            missing = self.nums[mid] - (mid + 1)

            if missing < k:
                start = mid + 1
            else:
                end = mid - 1
        print(f's={start}, e={end}')
        return end


if __name__ == "__main__":
    nums = [2, 3, 4, 7, 11]
    s = Solution(nums)
    k = 5
    start_index = s.find_kth_missing_num(k)
    print(f'start_index {start_index}')
    missing_till_start_index = nums[start_index] - (start_index + 1)
    print(f'missing till start {missing_till_start_index}')
    kth_missing =  nums[start_index] + k - missing_till_start_index
    print(f'kth_missing {kth_missing}')