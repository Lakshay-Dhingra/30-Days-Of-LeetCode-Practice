# https://leetcode.com/problems/longest-common-prefix/

import sys
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        ans=""
        ptr=0
        while(True):
            try:
                ch = strs[0][ptr]
                for s in strs:
                    if ch != s[ptr]:
                        return ans
                ans += ch
            except:
                # print(sys.exc_info())
                return ans
            ptr+=1