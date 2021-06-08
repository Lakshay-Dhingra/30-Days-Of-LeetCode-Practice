// https://leetcode.com/problems/jump-game-ii/

class Solution
{
    public int jump(int[] nums)
    {
        if(nums.length==1)
            return 0;
        
        int[] minJump = new int[nums.length];
        minJump[nums.length-1] = 0;
        int min=Integer.MAX_VALUE;
        
        for(int i=nums.length-2;i>=0;i--)
        {
            min = Integer.MAX_VALUE;
            for(int j=i+1;j<=i+nums[i];j++)
            {
                if(j>=nums.length)
                {
                    break;
                }
                if(minJump[j] < min)
                {
                    min = minJump[j];
                }
            }
            if(min == Integer.MAX_VALUE)
            {
                min--;
            }
            minJump[i] = min+1;
        }
        // for(int x:minJump)
        // System.out.print(x+" ");
        return minJump[0];
    }
    
}