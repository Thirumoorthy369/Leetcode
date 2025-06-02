class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>ans = new ArrayList<>();
        int cls = 0;
        int ros = 0;
        int cle = matrix[0].length-1;
        int roe = matrix.length-1;

        while(cls <= cle && ros <= roe){

            for(int i=cls; i<= cle; i++){
            ans.add(matrix[ros][i]);}
            ros++;

            for(int i=ros; i<= roe;i++){
            ans.add(matrix[i][cle]);}
            cle--;

            if(ros <= roe){
            for(int i=cle; i>=cls;i--){
            ans.add(matrix[roe][i]);}
            roe--;
            }

            if(cls <= cle){
                for(int i= roe; i>= ros; i--){
                ans.add(matrix[i][cls]);}
                cls++;
            }
        }
        return ans;
    }
}