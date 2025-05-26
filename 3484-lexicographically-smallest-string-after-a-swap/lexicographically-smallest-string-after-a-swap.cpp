class Solution {
public:
    string getSmallestString(string s) {
        int n = s.size();
        for(int i=1;i<n; i++){
           if ((s[i - 1] & 1) == (s[i] & 1) && s[i - 1] > s[i]) {
                swap(s[i], s[i - 1]);
                break;
        }
       
    }

     return s;
    }
};
