// https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int gap = (m+n+1)/2;
        int i=0;
        int temp=0;
        
        for(i=0;i<n;i++)
        {
            nums1[m+i] = nums2[i];
        }
        
        while(gap>0)
        {
            i=0;
            while(i+gap < m+n)
            {
                if(nums1[i] > nums1[i+gap])
                {
                    //swap
                    temp = nums1[i];
                    nums1[i] = nums1[i+gap];
                    nums1[i+gap] = temp;
                }
                i++;
            }
            if(gap == 1)
            {
                break;
            }
            gap = (gap+1)/2;
        }
        
    }
}