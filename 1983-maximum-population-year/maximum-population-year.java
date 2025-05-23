class Solution {
   
    public int maximumPopulation(int[][] logs) {
         int population[] = new int[101];
        int len = logs.length;

        for(int i = 0; i < len; i++){
            int birth = logs[i][0];
            int death = logs[i][1];

            for(int j = birth; j < death ; j++){
                population[j - 1950]++;
            }
        }
        int max = 1950;
        int maxpop = 0;

        for(int i=0; i<population.length;i++){
        if(population[i] > maxpop){
            maxpop = population[i];
            max = 1950 +i;
        }
        }
        return max;
    }
}