// https://leetcode.com/problems/combination-sum/

class Solution
{
    private static List<List<Integer>> ans;
    private static int[] arr;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        ans = new ArrayList<List<Integer>>();
        arr = candidates;
        generateAns(0, target, new ArrayList<Integer>());
        return ans;
    }
    private static void generateAns(int curindex, int target,ArrayList<Integer> curList)
    {
        if(target == 0)
        {
            ans.add(curList);
            return;
        }
        if(target < 0)
        {
            curList = null;
            return;
        }
        
        for(int i=curindex;i<arr.length;i++)
        {
            ArrayList<Integer> newlist = (ArrayList)curList.clone();
            newlist.add(arr[i]);
            generateAns(i, target-arr[i], newlist);
        }
    }
}