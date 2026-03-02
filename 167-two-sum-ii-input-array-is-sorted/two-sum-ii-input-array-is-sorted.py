class Solution:
    def twoSum(self, numbers, target):
        l=0
        r=len(numbers)-1
        while(l<r):
            c=numbers[l]+numbers[r]
            if(c==target):
                return[l+1,r+1]
            elif(c<target):
                l+=1
            else:
                r-=1
        