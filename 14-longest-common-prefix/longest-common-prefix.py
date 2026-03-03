class Solution:
    def longestCommonPrefix(self, strs):
        strs.sort() 
        first=strs[0]
        last=strs[-1] 
        result=[]
        for i in range(len(first)):
            if(i>len(last) or first[i]!=last[i]):
                break
            result.append(first[i])
        return"".join(result)