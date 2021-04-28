# https://leetcode.com/problems/palindrome-number/

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        x=str(x)
        n=len(x)
        for i in range((n+1)//2):
            if(x[i]!=x[n-1-i]):
                return False
        return True