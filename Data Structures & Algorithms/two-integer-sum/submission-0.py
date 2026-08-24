class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        s = {}
        i = 0
        for n in nums:
            if (target - n) in s:
                return [s.get(target-n), i]
            s[n] = i
            i = i + 1
        
        return [i, i]

        