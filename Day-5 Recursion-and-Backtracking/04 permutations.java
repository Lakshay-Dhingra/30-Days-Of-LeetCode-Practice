// https://leetcode.com/problems/permutations/

class Solution 
{
    private static List<List<Integer>> ans;
    private static int[] arr;
    public List<List<Integer>> permute(int[] nums)
    {
        arr=nums;
        ans = new ArrayList<List<Integer>>();
        generateAns(new ArrayList<Integer>());
        return ans;
    }
    
    private static void generateAns(ArrayList<Integer> curList)
    {
        if(curList.size() == arr.length)
        {
            ans.add(curList);
            return;
        }
        
        for(int val:arr)
        {
            if(!curList.contains(val))
            {
                ArrayList<Integer> newlist = (ArrayList<Integer>)curList.clone();
                newlist.add(val);
                generateAns(newlist);
            }
        }
    }
}