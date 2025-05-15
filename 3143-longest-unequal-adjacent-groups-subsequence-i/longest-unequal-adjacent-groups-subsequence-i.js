/**
 * @param {string[]} words
 * @param {number[]} groups
 * @return {string[]}
 */
function getLongestSubsequence(words, groups) {
    function build(start) {
        let res = [], expect = start;
        for (let i = 0; i < words.length; i++) {
            if (groups[i] === expect) {
                res.push(words[i]);
                expect ^= 1;
            }
        }
        return res;
    }
    let res1 = build(0), res2 = build(1);
    return res1.length >= res2.length ? res1 : res2;
}