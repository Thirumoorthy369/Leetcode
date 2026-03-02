class Solution:
    def majorityElement(self, nums):
        majority=nums[0]
        vote=1
        for i in range(1,len(nums)):
            if(vote==0):
                majority=nums[i]
                vote=1
            elif(majority==nums[i]):
                vote+=1
            else:
                vote-=1
        return majority
        