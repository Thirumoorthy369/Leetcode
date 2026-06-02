class Solution(object):
    def earliestFinishTime(self, landStartTime, landDuration, waterStartTime, waterDuration):
        ans = float('inf')

        for i in range(len(landStartTime)):
            for j in range(len(waterStartTime)):

                # Land -> Water
                landFinish = landStartTime[i] + landDuration[i]
                finalTime1 = max(landFinish, waterStartTime[j]) + waterDuration[j]

                # Water -> Land
                waterFinish = waterStartTime[j] + waterDuration[j]
                finalTime2 = max(waterFinish, landStartTime[i]) + landDuration[i]

                ans = min(ans, finalTime1, finalTime2)

        return ans