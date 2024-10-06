class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        s1 = sentence1.split()
        s2 = sentence2.split()

        if(len(s2)>len(s1)):
            s1,s2 = s2,s1

        # s1 is bigger, s2 smaller

        i=0
        while(i<len(s2) and s1[i]==s2[i]):
            i+=1

        j1=len(s2)
        i1=len(s1)
        count = 0
        while(j1>=0 and s1[i1-1]==s2[j1-1]):
            j1-=1
            i1-=1
            count+=1

        print('j is'+str(j1))

        return(i + count >= len(s2))

if __name__ == "__main__":
    s1 = "My name is Haley"
    s2 = "My Haley"
    s = Solution()
    print(s.areSentencesSimilar(s1, s2))
