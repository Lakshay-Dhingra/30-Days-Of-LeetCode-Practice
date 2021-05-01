// https://leetcode.com/problems/sudoku-solver/

class Solution {
    private static char[][] arr;
    public void solveSudoku(char[][] board)
    {
        arr=board;
        // System.out.println(solver(0,0));
        solver(0,0);
    }
    
    private static boolean solver(int i,int j)
    {
        if(j > 8)
        {
            return solver(i+1,0);
        }
        if(i > 8)
        {
            return true;
            //puzzle solved
        }
        
        if(arr[i][j] != '.')
        {
            return solver(i,j+1);
        }
        else
        {
            for(int x=1;x<10;x++)
            {
                char val = (char)(x+48);
                
                if(isValid(i,j,val))
                {
                    arr[i][j]=val;
                    if(solver(i,j+1))
                        return true;
                }
            }
            // System.out.println(i+" "+j);
            arr[i][j]='.';
            return false;
        }
    }
    
    
    private static boolean isValid(int iptr, int jptr,char val)
    {
        // int val = arr[iptr][jptr];
        // System.out.println(val);
        for(int j=0;j<9;j++)
        {
            if(j!=jptr)
            {
                if(arr[iptr][j] == val)
                    return false;
            }
        }
        
        for(int i=0;i<9;i++)
        {
            if(i!=iptr)
            {
                if(arr[i][jptr] == val)
                    return false;
            }
        }
        
        int biptr = ((int)iptr/3)*3;
        int bjptr = ((int)jptr/3)*3;
        
        for(int i=biptr;i<biptr+3;i++)
        {
            if(i!=iptr)
            for(int j=bjptr;j<bjptr+3;j++)
            {
                if(j!=jptr)
                {
                    if(arr[i][j] == val)
                        return false;
                }
            }
        }
        return true;
        
    }
}