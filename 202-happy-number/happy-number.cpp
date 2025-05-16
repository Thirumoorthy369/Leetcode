class Solution {
public:

    int compute(int n){
        int res=0;
        while(n != 0){
        res = res + (n%10) * (n%10);
        n = n/10;
        }
        return res;

    }


    bool isHappy(int n) {
       do{
        n = compute(n);
       }while(n != 1 && n!= 4);

       if(n==1) return true;
       return false;
    }
};