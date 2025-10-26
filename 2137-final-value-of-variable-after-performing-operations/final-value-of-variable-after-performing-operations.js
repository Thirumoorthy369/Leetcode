/**
 * @param {string[]} operations
 * @return {number}
 */
const finalValueAfterOperations = (ops) =>
    ops.reduce((r, v) => r + +`${v[1]}1`, 0);
    