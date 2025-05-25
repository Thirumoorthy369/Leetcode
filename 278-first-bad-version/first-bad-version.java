/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int bad =0,good =n;

        while(bad <= good){
            int ugly = bad+(good-bad)/2;
            if(isBadVersion(ugly)) good = ugly -1;
            else bad = ugly +1;
        }
        return bad;

    }
}