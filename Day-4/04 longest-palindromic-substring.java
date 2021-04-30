// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s)
    {
        int maxlptr = 0, maxrptr = 1;
        int maxlen = 1, len=0;
        int lptr, rptr = 0;
        
        
        //For Odd Size Palindromes
        for(int i=1;i<s.length();i++)
        {
            lptr = i-1;
            rptr = i+1;
            while(lptr>=0 && rptr<s.length())
            {
                if(s.charAt(lptr) == s.charAt(rptr))
                {
                    lptr--;
                    rptr++;
                }
                else
                {
                    break;
                }
            }
            lptr++;
            len = rptr-lptr;
            if(len > maxlen)
            {
                maxlen = len;
                maxlptr = lptr;
                maxrptr = rptr;
            }
        }
        
        //For Even Size Palindromes
        for(int i=0;i<s.length();i++)
        {
            lptr = i;
            rptr = i+1;
            while(lptr>=0 && rptr<s.length())
            {
                if(s.charAt(lptr) == s.charAt(rptr))
                {
                    lptr--;
                    rptr++;
                }
                else
                {
                    break;
                }
            }
            lptr++;
            len = rptr-lptr;
            if(len > maxlen)
            {
                maxlen = len;
                maxlptr = lptr;
                maxrptr = rptr;
            }
        }

        return s.substring(maxlptr,maxrptr);
        
    }
}