class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String [] nu = new String[n];
       
       for(int i = 0; i < n; i++){
            nu[i] = String.valueOf(nums[i]);
       }

       Arrays.sort(nu, (a, b) -> (b + a).compareTo(a + b));

        if(nu[0].equals("0")) return "0";

        StringBuilder res = new StringBuilder();

        for(String str : nu){
            res.append(str);
        }
        return res.toString();
    }
}