class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> flat;

        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                flat.push_back(grid[i][j]);

        int total = m * n;
        vector<int> shifted(total);
        for (int i = 0; i < total; ++i)
            shifted[(i + k) % total] = flat[i];

        vector<vector<int>> result(m, vector<int>(n));
        for (int i = 0; i < total; ++i)
            result[i / n][i % n] = shifted[i];

        return result;
    }
};
