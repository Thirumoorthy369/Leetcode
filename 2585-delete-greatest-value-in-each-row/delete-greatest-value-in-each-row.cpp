class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        for (int i = 0; i < m; i++){
            sort(grid[i].begin(), grid[i].end());
        }
        
        for (int j = 0; j < n; j++){
            int maxi = 0;
            for (int i = 0; i < m; i++){
                maxi = max(maxi, grid[i][j]);
            }
            ans += maxi;
        }
        return ans;

        // vector<vector<int>>dp(m, vector<int>(n-1));
        // return dpms(o,o,m,n,dp);
    }
};