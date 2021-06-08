// https://leetcode.com/problems/maximum-subarray/

//Kadane's Algo
//Keep a variable sum which stores the sum of array so far.
//At each iteration, check if sum is -ve and if it is, that means all the elements so far can't contribute to maximum sum, so we initialize it to zero.
//The maximum value of sum is the required answer.

class Solution {
    public int maxSubArray(int[] nums)
    {
        int sum=0;
        int maxsum = nums[0];
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>maxsum)
            {
                maxsum = sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxsum;
    }
}