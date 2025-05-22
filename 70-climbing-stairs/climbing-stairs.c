int climbStairs(int n) {
    int prev=1, curr=1, next =1, i=2;
    while(i <= n){

        next = prev + curr;
        prev = curr;
        curr = next;
        i = i+1;
    }
    return next;
}