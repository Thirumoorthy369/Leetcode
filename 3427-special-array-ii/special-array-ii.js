/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {boolean[]}
 */
var isArraySpecial = function(nums, queries) {
    const ans = [];
    let id = 0;
    const parityIds = [id];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] % 2 === nums[i - 1] % 2) {
            id += 1;
        }
        parityIds.push(id);
    }

    for (const [from, to] of queries) {
        ans.push(parityIds[from] === parityIds[to]);
    }

    return ans;
};