// https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s)
    {
        s=s.trim();
        s = s.split(" ")[0];
        
        boolean positive = true;
        if(s.equals(""))
        {
            return 0;
        }
        if(s.charAt(0) == '+')
        {
            s=s.substring(1);
        }
        else if(s.charAt(0) == '-')
        {
            positive = false;
            s=s.substring(1);
        }
        int ans=0;
        int rem=0;
        for(char ch:s.toCharArray())
        {
            if(ch>='0' && ch<='9')
            {
               rem = (int)(ch)-48;
               if(positive)
               {
                   if(ans > 214748364 || (ans == 214748364 && rem>7))
                   {
                       ans = 2147483647;
                       return ans;
                   }     
                   else
                        ans=ans*10+ rem;
               }
               else
               {
                   if(ans > 214748364 || (ans == 214748364 && rem>8))
                   {
                       ans = -2147483648;
                       return ans;
                   }   
                   else
                        ans=ans*10+ rem;
               }
            }
            else
            {
                break;
            }
        }
        
        if(!positive)
        {
            if(ans>0)
            {
                ans=ans*(-1);
            }
        }
        
        return ans;
    }
}