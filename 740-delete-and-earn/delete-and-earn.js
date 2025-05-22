/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    const count = new Map();
    for(let num of nums){
        count.set(num, (count.get(num) || 0)+1);
    }
    const unique = [...count.keys()].sort((a, b) => a - b);
    let take = 0, skip = 0, prev = null;

    for (let num of unique) {
        const currPoints = num * count.get(num);
        const maxPrev = Math.max(take, skip);
        if (prev === num - 1) {
            take = currPoints + skip;
            skip = maxPrev;
        } else {
            take = currPoints + maxPrev;
            skip = maxPrev;
        }
        prev = num;
    }
    return Math.max(take, skip);
};