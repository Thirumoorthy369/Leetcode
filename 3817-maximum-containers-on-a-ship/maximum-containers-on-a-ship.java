
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
       int a = n*n;
       int b = maxWeight /w;

       int c = Math.min(a,b);
       
        return c;
    }
}