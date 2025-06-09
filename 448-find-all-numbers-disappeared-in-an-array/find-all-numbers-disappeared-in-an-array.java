class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>res = new ArrayList<>();

        int [] re = new int[nums.length + 1];
        for(int n : nums){
            re[n] = n;
        }

        for(int i = 1; i <= nums.length; i++){
            if(re[i] == 0 ){
                res.add(i);
            }
        }
        return res;
    }
}