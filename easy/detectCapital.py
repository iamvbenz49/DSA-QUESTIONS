class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word)==1: return True
        if word[0].isupper() and word[1].isupper():
            for i in range(2,len(word)):
                if word[i].islower():
                    return False
            return True
        else:
            for i in range(1,len(word)):
                if word[i].isupper():
                    return False
            return True
          
          class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        return (word[0].isupper() and word[1:].islower()) or word.isupper() or word.islower()
