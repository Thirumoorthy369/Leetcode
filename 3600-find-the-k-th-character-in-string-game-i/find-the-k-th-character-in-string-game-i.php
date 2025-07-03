class Solution {

    /**
     * @param Integer $k
     * @return String
     */
    function kthCharacter($k) { 
    $index = $k - 1; 
    $increments = 0;
        
    while ($index > 0) { 
       $a = 1;
        while ($a * 2 <= $index) {
            $a *= 2;
        }
        $increments++; 
        $index -= $a;
    } 
    return chr(ord('a') + ($increments % 26));
    }
}