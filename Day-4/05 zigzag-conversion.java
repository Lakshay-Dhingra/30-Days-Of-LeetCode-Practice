// https://leetcode.com/problems/zigzag-conversion/submissions/

import java.util.*;
class Solution {
    public String convert(String s, int numrows)
    {
        if(numrows == 1)
        {
            return s;
        }
        
        ArrayList<Character>[] arr = new ArrayList[numrows];
        for(int i=0;i<numrows;i++)
        {
            arr[i] = new ArrayList();
        }
        
        int i=0;
        boolean diagonal = false;
        for(char ch:s.toCharArray())
        {
            if(i==numrows)
            {
                diagonal =true;
                i=numrows-2;
            }
            else if(i<0)
            {
                diagonal = false;
                i=1;
            }
            if(diagonal)
            {
                arr[i].add(ch);
                i--;
            }
            else
            {
                arr[i].add(ch);
                i++;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for(i=0;i<numrows;i++)
        {
            for(char ch:arr[i])
            {
                ans.append(ch);
            }
        }
        
        return ans.toString();
        
    }
}