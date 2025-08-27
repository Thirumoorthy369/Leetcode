class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDia=0;
        int maxArea=0;
        for(int i=0;i<dimensions.length;i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            int hypoSq =l*l + b*b;
            if(hypoSq>maxDia || (hypoSq==maxDia && l*b >maxArea )){
                maxDia = hypoSq;
                maxArea = l*b;
            }
        }
        return maxArea;
    }
}