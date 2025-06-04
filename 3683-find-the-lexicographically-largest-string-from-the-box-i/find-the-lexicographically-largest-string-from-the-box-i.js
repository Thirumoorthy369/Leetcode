/**
 * @param {string} word
 * @param {number} numFriends
 * @return {string}
 */
var answerString = function (word, numFriends) {
    if (numFriends == 1)
        return word;
    let n = word.length;
    let split_length = n - numFriends, m = '', cur = '';
    for (let i = 0; i < n; i++) {
        cur = word.slice(i, i + split_length + 1);
        if (cur > m) {
            m = cur;
        }
    }
    return m;
};