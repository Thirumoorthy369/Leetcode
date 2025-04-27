/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {
     let count = new Array(26).fill(0);
    
    // Count the frequency of each character in the input text
    for (let char of text) {
        count[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

   
    let bCount = count['b'.charCodeAt(0) - 'a'.charCodeAt(0)];
    let aCount = count['a'.charCodeAt(0) - 'a'.charCodeAt(0)];
    let lCount = Math.floor(count['l'.charCodeAt(0) - 'a'.charCodeAt(0)] / 2); 
    let oCount = Math.floor(count['o'.charCodeAt(0) - 'a'.charCodeAt(0)] / 2);
    let nCount = count['n'.charCodeAt(0) - 'a'.charCodeAt(0)];

    
    return Math.min(Math.min(bCount, aCount), Math.min(Math.min(lCount, oCount), nCount));
};