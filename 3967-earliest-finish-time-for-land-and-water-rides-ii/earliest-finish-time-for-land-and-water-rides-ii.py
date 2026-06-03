from bisect import bisect_right
from typing import List

class Solution:
    def solve(self, firstStart, firstDuration,
              secondStart, secondDuration):

        rides = sorted(zip(secondStart, secondDuration))

        starts = [s for s, d in rides]

        m = len(rides)

        prefix_min_duration = [0] * m
        prefix_min_duration[0] = rides[0][1]

        for i in range(1, m):
            prefix_min_duration[i] = min(
                prefix_min_duration[i - 1],
                rides[i][1]
            )

        suffix_min_finish = [0] * m
        suffix_min_finish[-1] = rides[-1][0] + rides[-1][1]

        for i in range(m - 2, -1, -1):
            suffix_min_finish[i] = min(
                suffix_min_finish[i + 1],
                rides[i][0] + rides[i][1]
            )

        ans = float('inf')

        for start, duration in zip(firstStart, firstDuration):

            finish_first = start + duration

            pos = bisect_right(starts, finish_first) - 1

            if pos >= 0:
                ans = min(
                    ans,
                    finish_first + prefix_min_duration[pos]
                )

            if pos + 1 < m:
                ans = min(
                    ans,
                    suffix_min_finish[pos + 1]
                )

        return ans

    def earliestFinishTime(
        self,
        landStartTime: List[int],
        landDuration: List[int],
        waterStartTime: List[int],
        waterDuration: List[int]
    ) -> int:

        ans1 = self.solve(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        )

        ans2 = self.solve(
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        )

        return min(ans1, ans2)