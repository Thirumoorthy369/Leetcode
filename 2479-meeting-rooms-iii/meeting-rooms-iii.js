/**************************\U0001f60e**************************/
const mostBooked = (n, m,
    c = Array(n).fill(0),
    q = MinPriorityQueue.fromArray(c.map((x, i) => [x, i]), x => x[1]),
    p = new MinPriorityQueue(x => x[0] * n + x[1]),
    $ = t => p.front()?.[0] <= t ? $(t, q.push(p.pop())) : (q.isEmpty() ? p : q).pop()
) => (
    m.sort(([a], [b]) => a - b).forEach(([s, e, [t, r] = $(s)]) => p.push([t > s ? e + t - s : e, r], ++c[r])),
    c.reduce((r, x, i) => x > c[r] ? i : r, 0)
)