// class Solution {
// public:
//     int minimumCost(vector<int>& cost) {
//         int res =0;
//         int n = cost.size();
//         sort(cost.begin(), cost.end());
        
//           for (int i = n - 1; i >= 0; i--) {
           
//             if ((n - 1 - i) % 3 == 2) {
//                 continue; 
//             }
//             res += cost[i];
//           }
        
//         return res;
//     }
    
// };

class Solution {
public:
    int minimumCost(vector<int>& cost) {
        sort(begin(cost), end(cost), greater<int>());
        
        int i = 0, n = cost.size();
        
        for (int i = 0; i < n / 3; i++) {
            cost[3 * (i + 1) - 1] = 0;
        }

        int res = 0;
        for (int n : cost) {
            res += n;
        }

        return res;
    }
};