/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number}
 */
var maxRemoval = function(nums, queries) {
    queries.sort((a, b) => a[0] - b[0]);
    let heap = new MaxPriorityQueue();
    let edges = new Array(nums.length + 1).fill(0);
    
    let cnt = 0;
    for (let i = 0, j = 0; i < nums.length; i++){
        cnt += edges[i];
        while (j < queries.length && queries[j][0] === i){
            heap.push(queries[j][1]);
            j++;
        }
        while (cnt < nums[i] && !heap.isEmpty() && heap.front() >= i){
            cnt += 1;
            edges[heap.pop() + 1] -= 1;
        }
        if (cnt < nums[i]){
            return -1;
        }

    }
    return heap.size();
};