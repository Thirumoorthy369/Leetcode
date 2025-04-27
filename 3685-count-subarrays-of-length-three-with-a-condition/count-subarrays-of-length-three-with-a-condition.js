/**
 * @param {number[]} nums
 * @return {number}
 */
var countSubarrays = function(nums) {
    let count = 0
    const n = nums.length -2;
    for(let i=0; i< n; i++){
        if(2* (nums[i]+nums[i+2]) === nums[i+1])
        count++;
    }
    return count;
};