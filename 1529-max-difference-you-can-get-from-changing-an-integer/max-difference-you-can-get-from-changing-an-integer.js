/**
 * @param {number} num
 * @return {number}
 */
var maxDiff = function (num) {
    let max = min = `${num}`;

    for (const digit of max) {
        if (digit === '9') continue;
        max = max.replaceAll(digit, '9');
        break;
    }
    for (let index = 0; index < min.length; index++) {
        const digit = min[index];

        if (index === 0) {
            if (digit !== '1') {
                min = min.replaceAll(digit, '1');
                break;
            }
        } else {
            if (digit !== '0' && digit !== min[0]) {
                min = min.replaceAll(digit, '0');
                break;
            }
        }
    }
    return max - min;
};