class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<Integer, Set<String>> hm = new HashMap<Integer, Set<String>>();
        int n = favoriteCompanies.size();
        for(int i = 0; i < n; i++){
            HashSet<String> hs = new HashSet<String>();
            for(String str : favoriteCompanies.get(i)){
                hs.add(str);
            }
            hm.put(i, hs);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            boolean subSet = false;
            List<String> curr = favoriteCompanies.get(i);
            for(int j = 0; j < n && !subSet; j++){
                if(favoriteCompanies.get(i).size() < favoriteCompanies.get(j).size()){
                    Set<String> set = hm.get(j);
                    int count = 0;
                    for(String str : curr){
                        if(set.contains(str)) {
                            count++;
                        }
                    }
                    if(count == curr.size()) {
                        subSet = true;
                    }
                }
            }
            if(!subSet) {
                res.add(i);
            }
        }
        return res;
    }
}