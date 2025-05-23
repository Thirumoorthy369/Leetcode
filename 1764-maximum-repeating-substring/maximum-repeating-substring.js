/**
 * @param {string} sequence
 * @param {string} word
 * @return {number}
 */
var maxRepeating = function(sequence, word) {
    let count = 0;
    while (sequence.includes(word.repeat(count + 1))) {
        count++;
    }
    return count;
};