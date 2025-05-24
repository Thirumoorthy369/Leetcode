function averageOfLevels(root) {
    if (!root) return [];

    const result = [];
    const queue = [root];

    while (queue.length > 0) {
        const n = queue.length;
        let sum = 0;

        for (let i = 0; i < n; i++) {
            const node = queue.shift();
            sum += node.val;

            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }

        result.push(sum / n);
    }

    return result;
}