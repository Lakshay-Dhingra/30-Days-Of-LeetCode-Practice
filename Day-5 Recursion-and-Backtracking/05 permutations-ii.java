// https://leetcode.com/problems/permutations-ii/

class Solution
{   
    private static List<List<Integer>> ans;
    private static HashMap<Integer, Integer> map;
    private static int maxlen;
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        maxlen = nums.length;
        map=new HashMap<>();
        for(int val:nums)
        {
            if(map.containsKey(val))
            {
                map.put(val,map.get(val)+1);
            }
            else
            {
                map.put(val,1);
            }
        }
        ans = new ArrayList<List<Integer>>();
        generateAns(new ArrayList<Integer>());
        return ans;
    }
    
    private static void generateAns(ArrayList<Integer> curList)
    {
        if(curList.size() == maxlen)
        {
            ans.add(curList);
            return;
        }
        
        for(int val:map.keySet())
        {
            if(Collections.frequency(curList, val) < map.get(val))
            {
                ArrayList<Integer> newlist = (ArrayList<Integer>)curList.clone();
                newlist.add(val);
                generateAns(newlist);
            }
        }
    }
}