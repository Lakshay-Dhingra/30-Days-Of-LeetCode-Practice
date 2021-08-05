// https://leetcode.com/problems/merge-intervals/

import java.util.*;

class SortByStart implements Comparator<int[]>
{
    //To sort in ascending order according to start value
    public int compare(int[] a, int[] b)
    {
        return a[0] - b[0];
    }
}

class Solution
{
    public int[][] merge(int[][] intervals)
    {        
        //Step-1 Sort The Intervals according to start value
        Arrays.sort(intervals, new SortByStart());
        
        // For testing
        // for(int i=0; i<intervals.length; i++)
        // {
        //     System.out.println(intervals[i][0]+" "+intervals[i][1]);
        // }
        
        ArrayList<int[]> ans = new ArrayList<int[]>();
        
        int[] prev = (int[])(intervals[0].clone());
        
        for(int[] interval:intervals)
        {
            //Checking if this interval overlaps with previous one.
            if(interval[0] >= prev[0] && interval[0] <= prev[1])
            {
                prev[1] = Math.max(prev[1],interval[1]);
            }
            else
            {
                ans.add(prev);
                prev = (int[])(interval.clone());
            }
        }
        ans.add(prev);
        
        int[][] finalans = new int[ans.size()][];
        for(int i=0;i<ans.size();i++)
        {
            finalans[i] = ans.get(i);
        }
        return finalans;
    }
}