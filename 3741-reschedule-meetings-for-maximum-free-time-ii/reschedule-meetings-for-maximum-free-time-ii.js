var maxFreeTime = function(eventTime, startTime, endTime) {
    const n = startTime.length;
    const gaps = new Array(n + 1);
    gaps[0] = startTime[0];
    for (let i = 1; i < n; i++) {
        gaps[i] = startTime[i] - endTime[i - 1];
    }
    gaps[n] = eventTime - endTime[n - 1];

    const dpLeft = new Array(n + 1);
    const dpRight = new Array(n + 1);

    dpLeft[0] = gaps[0];
    for (let i = 1; i <= n; i++) {
        dpLeft[i] = Math.max(dpLeft[i - 1], gaps[i]);
    }

    dpRight[n] = gaps[n];
    for (let i = n - 1; i >= 0; i--) {
        dpRight[i] = Math.max(dpRight[i + 1], gaps[i]);
    }

    let maxFree = 0;
    for (let i = 0; i < n; i++) {
        const dur = endTime[i] - startTime[i];
        const combined = gaps[i] + gaps[i + 1];
        let bestAlt = 0;

        if (i > 0) bestAlt = Math.max(bestAlt, dpLeft[i - 1]);
        if (i + 2 <= n) bestAlt = Math.max(bestAlt, dpRight[i + 2]);

        if (dur <= bestAlt) {
            maxFree = Math.max(maxFree, combined + dur);
        } else {
            maxFree = Math.max(maxFree, combined);
        }
    }

    return maxFree;
};
