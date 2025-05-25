class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;

        Map<String, Integer> reversedWordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reversedWordMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                if (isPalindrome(prefix)) {
                    Integer match = reversedWordMap.get(suffix);
                    if (match != null && match != i) {
                        result.add(Arrays.asList(match, i));
                    }
                }

            
                if (j != len && isPalindrome(suffix)) {
                    Integer match = reversedWordMap.get(prefix);
                    if (match != null && match != i) {
                        result.add(Arrays.asList(i, match));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
