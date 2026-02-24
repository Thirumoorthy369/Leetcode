class Solution:
    def capitalizeTitle(self, title: str) -> str:
        words = title.split()
        result = []
        for word in words:
            if len(word) > 2:
                result.append(word[0].upper() + word[1:].lower())
            else:
                result.append(word.lower())
        return ' '.join(result)
