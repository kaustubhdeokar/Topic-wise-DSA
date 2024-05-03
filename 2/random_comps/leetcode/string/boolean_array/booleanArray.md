Good way to store letters used in a word, using a array of length 26. 


```
String a1 = scanner.next();

int[] charMap = new int[26];

for(int i=0;i<a1.length();i++){
    charMap[a1.charAt(i)-'a'] = 1;
}

```

> Problems to match frequencies of characters can use this technique very efficiently.
