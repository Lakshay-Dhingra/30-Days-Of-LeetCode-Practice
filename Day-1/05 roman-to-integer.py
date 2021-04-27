# https://leetcode.com/problems/roman-to-integer/submissions/

class Solution:
    def romanToInt(self, s: str) -> int:
        ans=0
        for i in range(len(s)):
            ch=s[i]
            if(ch=='M'):
                ans+=1000
            elif(ch=='D'):
                ans+=500
            elif(ch=='C'):
                ans+=100
                if(i!=len(s)-1):
                    if(s[i+1]=='D' or s[i+1]=='M'):
                        ans-=200
            elif(ch=='L'):
                ans+=50
            elif(ch=='X'):
                ans+=10
                if(i!=len(s)-1):
                    if(s[i+1]=='L' or s[i+1]=='C'):
                        ans-=20
            elif(ch=='V'):
                ans+=5
            elif(ch=='I'):
                ans+=1
                if(i!=len(s)-1):
                    if(s[i+1]=='V' or s[i+1]=='X'):
                        ans-=2
        return ans