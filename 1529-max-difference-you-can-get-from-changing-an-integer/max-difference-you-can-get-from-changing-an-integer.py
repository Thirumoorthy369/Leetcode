class Solution(object):
    def maxDiff(self, num):
        """
        :type num: int
        :rtype: int
        """

        str1 = str(num)
        str2 = str1.replace(str1[0],'9')
        str3 = str1.replace(str1[0],'1')

        i = 1
        while((str2 == str1) and (i < len(str2))):
            str2 = str1.replace(str1[i],'9')
            i += 1
        
        i = 1
        while((str3 == str1) and (i < len(str3))):
            if(str3[0] == str3[i]):
                i += 1
                continue
            str3 = str1.replace(str1[i],'0')
            i += 1

        return int(str2) - int(str3)