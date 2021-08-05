// https://leetcode.com/problems/powx-n/

class Solution
{
    //using binary exponentiation
    public double myPow(double x, int n)
    {
        if(n==0)
        {
            return 1;
        }
        if(n>0)
        {
            return pow(x,n);
        }
        else
        {
            return negpow(x,n);
        }
    }
    private double pow(double x, int n)
    {
        if(n==1)
        {
            return x;
        }
        
        if(n%2 == 1)    //if power is odd
        {
            return x*pow(x,n-1);
        }
        else
        {
            double temp = pow(x,n/2);
            return temp*temp;
        }
    }
    
    private double negpow(double x, int n)
    {
        if(n==-1)
        {
            return (1/x);
        }
        
        if(n%2 == 0)    //if power is even
        {
            double temp = negpow(x,n/2);
            return temp*temp;
        }
        else
        {
            return (1/x)*negpow(x,n+1);
        }
    }
}