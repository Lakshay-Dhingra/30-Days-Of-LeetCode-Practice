// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height)
    {
        int sptr = 0;
        int bptr = height.length-1;
        int maxarea = 0, area=0;
        
        while(sptr<bptr)
        {
            area = (bptr-sptr) * Math.min(height[bptr], height[sptr]);
            if(area > maxarea)
            {
                maxarea = area;
            }
            
            if(height[sptr]>height[bptr])
            {
                bptr--;
            }
            else
            {
                sptr++;
            }
        }
        return maxarea;
    }
}