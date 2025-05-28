var rowAndMaximumOnes = function(mat) {
    let maxCount = 0;
    let maxIndex = 0;

    const n = mat.length;
    const m = mat[0].length;

    for(let i = 0; i < n; i++) {
        let newMaxCount = 0;

        for(let j = 0; j < m; j++) {
            if(mat[i][j] === 1) {
                newMaxCount++;
            }
        }

        if(newMaxCount > maxCount) {
            maxCount = newMaxCount;
            maxIndex = i;
        }
    }

    return [maxIndex, maxCount];
};