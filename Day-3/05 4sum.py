# https://leetcode.com/problems/4sum/

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n=len(nums)
        ans=list()
        
        if(len(nums) < 4):
            return ans
        
        prevj = nums[0]-1
        for j in range(n-2):
            prevnum = nums[0]-1
            if(nums[j] == prevj):
                continue
            
            for i in range(j+1,n-1):
                if(nums[i] == prevnum):
                    continue

                fptr = i+1
                bptr = n-1
                reqdSum = target-(nums[i]+nums[j])

                while(fptr<bptr):
                    mysum=nums[fptr]+nums[bptr]
                    if( mysum < reqdSum):
                        fptr+=1
                    elif(mysum > reqdSum):
                        bptr-=1
                    else:
                        ans.append([nums[j],nums[i], nums[fptr], nums[bptr]])

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
            prevj = nums[j]
        return ans