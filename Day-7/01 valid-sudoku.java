// https://leetcode.com/problems/valid-sudoku/

class Solution
{
    private static char[][] arr;
    public boolean isValidSudoku(char[][] board)
    {
        arr=board;
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(arr[i][j] != '.')
                {
                    if(!isValid(i,j))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static boolean isValid(int iptr, int jptr)
    {
        char val = arr[iptr][jptr];
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