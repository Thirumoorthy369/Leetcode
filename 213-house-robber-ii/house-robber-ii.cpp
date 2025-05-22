class Solution {
public:
    int robRange(vector<int>& nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; ++i) {
            int next = max(curr, prev + nums[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    int rob(vector<int>& nums) {
        int N = nums.size();
        if (N == 0) return 0;
        if (N == 1) return nums[0];

        // Case 1: Rob houses 0 to N-2 (exclude the last house)
        int case1 = robRange(nums, 0, N - 2);
        
        // Case 2: Rob houses 1 to N-1 (exclude the first house)
        int case2 = robRange(nums, 1, N - 1);

        // Return the maximum of both cases
        return max(case1, case2);
    }
};
