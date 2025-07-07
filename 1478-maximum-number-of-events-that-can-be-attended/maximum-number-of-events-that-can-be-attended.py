class Solution(object):
    def maxEvents(self, events):
        """
        :type events: List[List[int]]
        :rtype: int
        """
        events.sort()
        res=0
        i=0
        day=1
        mini=[]
        n=len(events)

        while i<n or mini:
            while i<n and events[i][0]==day:
                heappush(mini,events[i][1])
                i+=1
            while mini and mini[0]<day:
                heappop(mini)
            if mini:
                heappop(mini)
                res+=1
            day+=1
        return res        