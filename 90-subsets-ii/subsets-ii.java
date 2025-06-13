class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
     List<List<Integer>> pathil = new ArrayList<>();
     Arrays.sort(nums);
        subset(pathil, new ArrayList<>(), nums, 0);
        return pathil;
    }

    public void subset(List<List<Integer>>res, List<Integer>tl, int[] num, int s)
    {
        res.add(new ArrayList<>(tl));

       

        for(int i=s; i < num.length; i++){

            if(i > s && num[i] == num[i-1])continue;

            tl.add(num[i]);
            subset(res, tl, num, i+1);
            tl.remove(tl.size()-1);
        }
    }
}



