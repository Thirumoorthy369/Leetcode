class Solution {
public:
    string triangleType(vector<int>& nums) {
        unordered_set<int>s1;
        int count =0;
        int n = nums.size();

        for(int i=0; i<n;i++){
            if(s1.count(nums[i])==1) count++;
            s1.insert(nums[i]);
        }
          if (nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0]) {
            return "none";
        }
        if(count == 2) return "equilateral";
        else if(count == 1) return "isosceles";
        else if(count == 0) return "scalene";
        else return "none";
        
    }
};