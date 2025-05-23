class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n1 = s1.length(); int n2 = s2.length();

        if(n1 != n2) return false;
        List<Integer> indexes = new ArrayList<>();

        for(int i=0; i< n1;i++){
            if(s1.charAt(i) != s2.charAt(i)) indexes.add(i);
             if (indexes.size() > 2) 
                return false;
        }

        if (indexes.size() == 2) {
        int i = indexes.get(0);
        int j = indexes.get(1);
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }

    return indexes.size() == 0; 

    }
}