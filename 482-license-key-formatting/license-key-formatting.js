/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var licenseKeyFormatting = function(s, k) {
    let temp = s.replaceAll('-', '').toUpperCase('').split('');
    for (let i = temp.length - 1 - k; i >= 0; i -= k) {
        temp[i] += '-';
    }
    return result = temp.join('');
};