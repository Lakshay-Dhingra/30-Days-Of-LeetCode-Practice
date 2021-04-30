# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution:
    def letterCombinations(self, digits: str) -> List[str]: 
        di = {"2":"abc", "3":"def", "4":"ghi", "5":"jkl", "6":"mno", "7":"pqrs", "8":"tuv", "9":"wxyz"}
        ans = []
        for digit in digits:
            if len(ans) == 0:
                for letter in di[digit]:
                    ans.append(letter)
            else:
                new_ans = []
                for i in ans:
                    for letter in di[digit]:
                        new_ans.append(i+letter)
                ans = new_ans
        return ans