class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count=0;
        int n = startTime.length;
        for(int i=0; i<n;i++){
              if (startTime[i] <= queryTime && queryTime <= endTime[i])
              count++;
        }
        return count;
        // for(int i=0;i<startTime.length;i++){
        //    // int student = startTime[i];
        //     for(int j=0;j<endTime.length;j++){

        //         if(startTime[i] == endTime[i]){
        //             count++;
        //         }
        //         else if(startTime[i] == queryTime)count++;
        //         else break;
                

        //     }
        // }
        // return count;
    }
}