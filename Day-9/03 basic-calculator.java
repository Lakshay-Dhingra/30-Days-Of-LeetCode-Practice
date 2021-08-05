// https://leetcode.com/problems/basic-calculator/

// NOT COMPLETED YET!!
class Solution {
    public int calculate(String s)
    { 
        return calc(s,0);   
    }
    private int calc(String s, int pos)
    {
        int ans=0;
        char ch;
        int symbol = 1;
        int digit = 0;
        while(pos<s.length())
        {
            ch = s.charAt(pos);
            if(ch == ' ' || ch == '(' || ch == ')')
            {
                ans += digit;
                digit = 0;
                pos++;
                continue;
            }
            else if(ch >= '0' && ch<='9')
            {
                digit= digit*10 + (((int)ch)-48)*symbol;
            }
            else if(ch == '+')
            {
                ans += digit;
                digit = 0;
                symbol = 1;
            }
            else if(ch == '-')
            {
                ans += digit;
                digit = 0;
                symbol = -1;
            }
            pos++;
        }
        
        if(digit != 0)
        {
            ans += digit;
        }
        
        return ans;
    }
}