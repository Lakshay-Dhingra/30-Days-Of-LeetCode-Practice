// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        int l=0;
        int r=0;
        HashSet<Character> set = new HashSet<>();
        int maxlength = 0;
        int len = 0;
        while(r<s.length())
        {
            if(set.contains(s.charAt(r)))
            {
                set.remove(s.charAt(l));
                l++;
            }
            else
            {
                set.add(s.charAt(r));
                len=r-l+1;
                if(len > maxlength)
                {
                    maxlength=len;
                }
                r++;
            }
            // System.out.println("l:"+l+" r:"+r+" maxlen:"+maxlength);
        }
        return maxlength;
    }
}