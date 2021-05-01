// https://leetcode.com/problems/generate-parentheses/

class Solution
{
    private static ArrayList<String> ans;
    private static int maxpair;
    public List<String> generateParenthesis(int n)
    {
        ans = new ArrayList<>();
        maxpair = n;
        genAnswer(0,0,"");
        return ans;
        
    }
    
    public void genAnswer(int opening, int closing, String curStr)
    {
        if(curStr.length() == maxpair*2)
        {
            ans.add(curStr);
            return;
        }
        
        if(opening < maxpair)
        {
            genAnswer(opening+1, closing, curStr+"(");
        }
        
        if(closing<opening)
        {
            genAnswer(opening, closing+1, curStr+")");
        }
    }
    
}