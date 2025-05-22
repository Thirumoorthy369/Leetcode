class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int>v;
        for(int i=0; i<n; i++){
            int a = nums[i]*nums[i];
            v.push_back(a);
        }
        sort(v.begin(), v.end());
        return v;
    }
};