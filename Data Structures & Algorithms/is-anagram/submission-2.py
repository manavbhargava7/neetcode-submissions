class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #create set for each letter, then check if both dicts r equal
        if len(s) != len(t):
            return False

        sMap = {}
        tMap = {}

        for l in s:
            if l in sMap:
                sMap[l] = sMap[l] + 1
            else:
                sMap[l] = 1
        
        for l in t:
            if l in tMap:
                tMap[l] = tMap[l] + 1
            else:
                tMap[l] = 1
        
        return sMap == tMap