class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if (counts.get(c) == 1) { 
                return i; 
            }
        }

        return -1; 
    }
}