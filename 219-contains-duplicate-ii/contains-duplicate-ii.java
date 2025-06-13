class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> n = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int m = nums[i];
            if(n.containsKey(m)){
                if(Math.abs(n.get(m)-i) <= k)
                return true;
                else
                n.put(m, i);
            }
            else
            n.put(m, i);
        }
        return false;
    }
}