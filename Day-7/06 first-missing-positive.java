// https://leetcode.com/problems/first-missing-positive/

//Bring every number from 1 to n to same position as the number i.e. 1 is at position 1 (or index=0), 2 is at position 2 and so on...
//Ignore the numbers greater than length of array or -ve numbers
//The first number from 1 to n which is not at its correct position is the first missing positive.

//T.C = O(n) and S.C. = O(1)

class Solution
{
    public int firstMissingPositive(int[] nums) 
    {
        int i=0, temp=0;
        while(i<nums.length)
        {
            if(nums[i]<=0 || nums[i] > nums.length)
            {
                //ignore -ve and big numbers
                i++;
            }
            else if(nums[i] == i+1)
            {
                //already at correct position
                i++;
            }
            else
            {
                if(nums[nums[i]-1] == nums[i])
                {
                    //to prevent infinite loop if both are equal
                    i++;
                } 
                else
                {
                    //swapping to get nums[i] to its correct position
                    temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];  //nums[i]-1 bcz index = position-1
                    nums[i] = temp;
                }
                
            }
        }
        
        
        for(i=0;i<nums.length;i++)
        {
            if(i+1 != nums[i])
            {
                return i+1;
            }
        }
        return nums.length+1;
        
    }
}