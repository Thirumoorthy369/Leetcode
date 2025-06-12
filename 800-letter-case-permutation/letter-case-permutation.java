class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String>result = new ArrayList<>();
        generatepermutation(0, "", result, s);
        return result;
    }

    private void generatepermutation(int n, String part, List<String> res, String s){
        if(part.length() == s.length()){
            res.add(part);
            return;
        }
        char currchar = s.charAt(n);

        if(Character.isAlphabetic(currchar)){
            generatepermutation(n + 1, part+ Character.toLowerCase(currchar), res, s);
            generatepermutation(n + 1, part+ Character.toUpperCase(currchar), res, s);
        }
        else
            generatepermutation(n + 1, part+currchar, res, s);
            
    }
}