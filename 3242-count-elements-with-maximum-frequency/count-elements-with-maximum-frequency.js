/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    // Edge case: single element array
    if(nums.length == 1) return 1;

    // Count frequency of each element
    let freq = new Map();
    for(let i = 0; i < nums.length; i++){
        freq.set(nums[i], (freq.get(nums[i]) || 0) + 1);
    }
    
    // Extract frequency values and sort in descending order
    let freqArr = [...freq.values()];
    freqArr.sort((a, b) => b - a);
    
    // Maximum frequency is the first element after sorting
    let ref = freqArr[0];
    let res = freqArr[0]; // Start with the first max frequency
    
    // Add all other frequencies that equal the maximum
    for(let i = 1; i < freqArr.length; i++){
        if(freqArr[i] == ref){
            res += freqArr[i];
        }
    }

    return res;
};