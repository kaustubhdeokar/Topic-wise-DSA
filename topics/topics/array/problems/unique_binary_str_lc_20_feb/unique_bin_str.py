class Leetcode_daily:
    def __init__(self):
        pass

    def feb_20_unique_binary_string(self, nums: list[str]):
        nums_set = set()
        for num in nums:
            num = self.convert_to_num(num)  # n<=16, constant time.
            nums_set.add(num)
        limit = pow(2, len(nums[0]))
        for i in range(0, limit):  # n time
            if i not in nums_set:
                if i == 0: return '0' * len(nums)
                return self.convert_to_str(i, len(nums[0]))
        return -1

    def convert_to_num(self, num_str: str):
        multiplier = 0
        ans = 0
        for i in range(0, len(num_str)):
            char = num_str[len(num_str) - i - 1]
            digit = int(char)
            ans += digit * pow(2, multiplier)
            multiplier += 1
        return ans

    def convert_to_str(self, num: int, len_of_number:int) -> str:
        res_str = []
        while num > 0:
            res_str.append(str(num % 2))
            num //= 2
        result_str = ''.join(reversed(res_str))
        return '0'*(len_of_number - len(result_str)) + result_str


def feb_20():
    l = Leetcode_daily()
    nums = ["000", "100"]
    print(l.feb_20_unique_binary_string(nums))

    nums = ["00", "01", "11","10"]
    print(l.feb_20_unique_binary_string(nums))


if __name__ == "__main__":
    feb_20()
