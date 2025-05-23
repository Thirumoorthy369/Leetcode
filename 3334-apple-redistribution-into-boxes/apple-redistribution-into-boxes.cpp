class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& capacity) {
        int n=apple.size();
        int m=capacity.size();
        int sum=accumulate(apple.begin(),apple.end(),0);
        sort(capacity.begin(),capacity.end(),greater<int>());
        int curr=0;int ans=1;
        for(int i=0;i<m;i++){
            curr+=capacity[i];
            if(curr<sum){
                ans++;
            }
        }
        return ans;

    }
};