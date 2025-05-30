class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
       if(nums.size() == 1)
        {
            return true;
        }
        bool a=true,b=true;;
        for(int j=1;j<nums.size();j++)
        {
            if(nums[j]<nums[j-1])
            {
                a=false;
                break;
            }
        }
        for(int j=1;j<nums.size();j++)
        {
            if(nums[j]>nums[j-1])
            {
                b=false;
                break;
            }
        }
        return a || b;
    }
};