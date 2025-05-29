class Solution(object):
    def countTriples(self, n):
        """
        :type n: int
        :rtype: int
        """
        a = 0
        for i in range(1,n+1):
            for j in range(i+1, n+1):
                for k in range(j+1, n+1):
                    if(i*i)+(j*j)== k*k:
                        a += 2
        return a                
        