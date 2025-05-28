class Solution {
public:
       bool canThreePartsEqualSum(vector<int>& arr) {
    int s = 0, n = arr.size();
    for (int i = 0; i < n; i++) {
        arr[i] += s; s = arr[i];
    }
    if (s % 3)
        return false;
    s /= 3;
    int c = 1;
    for (int i = 0; i < n; i++)
        if (arr[i] == s * c)
            c++;
    return c > 3;
}
};