class Solution {
    public int minNumberOperations(int[] target) {
         int operations = target[0];
        for (int i = 1; i < target.length; i++) {
            operations += Math.max(target[i] - target[i - 1], 0);
        }
        return operations;
    }
}