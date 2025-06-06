

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        double prev = 1;
        for (int k = 1; k <= rowIndex; k++) {
            double next_val = prev * (rowIndex - k + 1) / k;
            res.add((int)next_val);
            prev = next_val;
        }
        return res;
    }
}