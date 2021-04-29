// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s)
    {
        Stack<Character> stk = new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch == '(')
            {
                stk.push(')');
            }
            else if(ch == '{')
            {
                stk.push('}');
            }
            else if(ch == '[')
            {
                stk.push(']');
            }
            else
            {
                if(stk.empty())
                {
                    return false;
                }
                else if(stk.pop() != ch)
                {
                    return false;
                }
            }
        }
        
        if(stk.empty())
            return true;
        else
            return false;
    }
}