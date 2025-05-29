'''
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
''' 
class Solution(object):
    def countTriples(self, n):
        possible = [5, 13, 17, 25, 29, 37, 41, 53, 61, 65, 65, 73, 85, 85, 89, 97, 101, 109, 113, 125, 137, 145, 145, 149, 157, 169, 173, 181, 185, 185, 193, 197, 205, 205, 221, 221, 229, 233, 241 ]
        count = 0
        for x in possible:
            count += n//x
        return 2 * count
               