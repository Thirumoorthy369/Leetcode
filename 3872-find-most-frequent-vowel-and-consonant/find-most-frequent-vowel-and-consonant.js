/**
 * @param {string} s
 * @return {number}
 */
var maxFreqSum = function(s) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u'])
    const freq = Array(26).fill(0);
    let max_vowel = 0, max_cons = 0;
    for (let c of s){
        let idx = c.charCodeAt(0) - 97;
        freq[idx]++;
        if (vowels.has(c)){
            max_vowel = Math.max(max_vowel, freq[idx]);
        } else {
            max_cons = Math.max(max_cons, freq[idx]);
        }
    }
    return max_vowel + max_cons;
};