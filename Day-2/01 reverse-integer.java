// https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x)
    {
        try
        {
            boolean positive=true;
            if(x<0)
            {
                positive = false;
                x=x*(-1);
            }
            int ans=0;

            while(x>0)
            {   
                if(ans>Integer.MAX_VALUE/10)
                {
                    return 0;
                }
                ans=ans*10;
                ans+=x%10;
                x=x/10;
                // System.out.println(ans);
            }
            
            if(!positive)
            {
                ans=ans*(-1);
            }
            return ans;       
        }
        catch(Exception e)
        {
            return 0;      
        }
    }
}