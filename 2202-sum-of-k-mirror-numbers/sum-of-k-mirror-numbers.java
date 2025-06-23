class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        for (int length = 1; count < n; length++) {
            for (String half : generatePalindromes(length)) {
                String decPal = half + new StringBuilder(half.substring(0, length / 2)).reverse();
                long num = Long.parseLong(decPal);
                if (isPal(inBaseK(num, k))) {
                    sum += num;
                    if (++count == n) return sum;
                }
            }
        }
        return sum;
    }

    private List<String> generatePalindromes(int len) {
        List<String> res = new ArrayList<>();
        int half = (len + 1) / 2;
        int start = (int)Math.pow(10, half - 1);
        int end = (int)Math.pow(10, half);
        for (int i = start; i < end; i++) {
            res.add(Integer.toString(i));
        }
        return res;
    }

    private String inBaseK(long x, int k) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append((char)('0' + (x % k)));
            x /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPal(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
