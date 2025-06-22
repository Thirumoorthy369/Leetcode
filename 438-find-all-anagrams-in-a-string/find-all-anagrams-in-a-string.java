import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m) return res;

        int[] pCnt = new int[26], wCnt = new int[26];
        for (char c : p.toCharArray())
            pCnt[c - 'a']++;

        for (int i = 0; i < n; i++) {
            wCnt[s.charAt(i) - 'a']++;
            if (i >= m) 
                wCnt[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(pCnt, wCnt))
                res.add(i - m + 1);
        }
        return res;
    }
}
