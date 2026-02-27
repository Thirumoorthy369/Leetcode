class Solution:
    def findEvenNumbers(self, digits):
        from collections import Counter
        
        # Count frequency of each digit
        count = Counter(digits)
        
        result = []
        
        # Try all 3-digit even numbers from 100 to 998
        for num in range(100, 1000, 2):
            s = str(num)
            
            # Check if first digit is non-zero (already true for 100-998)
            if s[0] == '0': 
                continue
                
            # Count digits needed for this number
            temp_count = Counter(map(int, s))
            
            # Check if we have enough digits available
            if all(temp_count[d] <= count[d] for d in temp_count):
                result.append(num)
        
        return sorted(result)