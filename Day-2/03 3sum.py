# https://leetcode.com/problems/3sum/

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n=len(nums)
        ans=list()
        
        if(len(nums) == 0):
            return ans
        
        
        prevnum = nums[0]-1
        for i in range(n-1):
            if(nums[i] == prevnum):
                continue
            
            fptr = i+1
            bptr = n-1
            reqdSum = -1*nums[i]
            
            while(fptr<bptr):
                mysum=nums[fptr]+nums[bptr]
                if( mysum < reqdSum):
                    fptr+=1
                elif(mysum > reqdSum):
                    bptr-=1
                else:
                    ans.append([nums[i], nums[fptr], nums[bptr]])
                    
                    prev = nums[fptr]
                    fptr+=1
                    while(fptr<n):
                        if(nums[fptr]>prev):
                            break
                        fptr+=1
                    
                    prev = nums[bptr]
                    bptr-=1
                    while(bptr>i):
                        if(nums[bptr]<prev):
                            break
                        bptr-=1
                        
            prevnum = nums[i]
        return ans
                    
