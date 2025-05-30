class Solution 
{
    public int closestMeetingNode(int[] edges, int node1, int node2)
    {
        int n = edges.length;
        int[] dist1 = minDist(edges, node1, n);
        int[] dist2 = minDist(edges, node2, n);
        
        int minDist = Integer.MAX_VALUE, res = -1;
        for(int i = 0; i < n; i++)
        {
            if(dist1[i] > -1 && dist2[i] > -1 && Math.max(dist1[i], dist2[i]) < minDist){
                minDist = Math.max(dist1[i], dist2[i]);
                res = i;
            }
        }
        return res;
    }
    
    int[] minDist(int[] edges, int node, int n)
    {
        int[] ar = new int[n];
        Arrays.fill(ar, -1);
        ar[node] = 0;

        if(edges[node] != -1) node = edges[node];
        
        int steps = 1;
        while(node != -1)
        {
            if(ar[node] == -1)
            {
                ar[node] = steps++;
                node = edges[node];
            }
            else
                node = -1;
        }
        return ar;
    }
}