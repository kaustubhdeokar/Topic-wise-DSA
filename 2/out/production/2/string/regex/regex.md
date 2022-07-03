```
Pattern.matches(".*[A-Z]+.*",innerString); //A-Z
Pattern.matches(".*[0-9]+.*",innerString); //digits
Pattern.matches(".*[@#%&?]+.*",innerString);//special chars
Pattern.matches(".*[a-z]+.*",password);//a-z

```         
            
> [abc] - a,b or c
  [^abc] any class except a,b,c.
  [a-zA-Z] A - Z a-z.
  [a-d[m-p]] a-d & m-p (union)
  [a-d && [def]] -> d (intersection)
  [a-z && [^bc]] a-z but not b,c.
  [a-z && [^b-e]] a-z but not b,c,d,e.


