class Solution {
    public List<String> fizzBuzz(int n) {
        List<String>sh = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(i%3==0 && i % 5 == 0){
                 sh.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                sh.add("Fizz");
            }
            else if(i % 5 == 0){
                sh.add("Buzz");
            }
            else sh.add(String.valueOf(i));

        }
        return sh;
    }
}