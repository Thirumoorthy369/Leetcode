class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> trustCount(n + 1, 0);  
        vector<int> trustedBy(n + 1, 0);   

        for (auto& t : trust) {
            int a = t[0];
            int b = t[1];
            trustedBy[a]++;   
            trustCount[b]++;  
        }

        for (int i = 1; i <= n; ++i) {
            if (trustCount[i] == n - 1 && trustedBy[i] == 0)
                return i; 
        }

        return -1; 
    }
};
