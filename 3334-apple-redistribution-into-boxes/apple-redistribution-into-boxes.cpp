class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& cap) {
        int ac=0;
    for(auto i:apple){
        ac+=i;
    }
    sort(cap.rbegin(),cap.rend());
    int count=0;
    int res =0; 
    for(auto j:cap){
    res+=j;
    count++;
    if(res>=ac) break;
    }
    return count;    
    }
};