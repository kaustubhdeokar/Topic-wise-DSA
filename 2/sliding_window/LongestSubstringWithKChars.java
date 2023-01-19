public class LongestSubstringWithKChars {
    
    public static void main(String[] args) {
        
        String str = "aaaa";
        int k = 2;

        System.out.println("MAX LEN:"+longestSustringWithK(str, k));

        // str = "aaaa";
        // k = 2;
        // System.out.println("MAX LEN:"+longestSustringWithK(str, k));
    }

    public static int longestSustringWithK(String str, int k){
        
        int start = 0;
        int end = 0;
        int maxLen = -1;

        int[] chars = new int[26];
        int[] count = new int[1];
        System.out.println(str);
        while(start < str.length() && end <= str.length()){
            
            if(end < str.length() && count[0] < k){
                addChar(str.charAt(end), chars, count);
                System.out.println("char added");
                end += 1;
            }
            else if(count[0] > k){
                removeChar(str.charAt(start), chars, count);
                System.out.println("char removed");
                start += 1;
            }
            if(count[0] == k){
                System.out.println("match");
                
                //if(start == 0) maxLen = Integer.max(maxLen, end - start); 
                maxLen = Integer.max(maxLen, end - start);

                System.out.println("end:"+end+" ,start:"+start+" ,maxLen:"+maxLen);
    
                if(end<str.length()){
                    addChar(str.charAt(end), chars, count);
                }

                end += 1;
                System.out.println("after match, char added, count:"+count[0]);
            }

            if(end == str.length() && start == 0 && count[0] < k){
                break;
            }

        }
        return maxLen;
    }

    public static void addChar(char currChar, int[] chars, int[] count){
        
        if(chars[currChar - 'a'] == 0){
            count[0]+=1;
        }
        chars[currChar - 'a'] += 1;
        
    }

    public static void removeChar(char currChar, int[] chars, int[] count){

        chars[currChar - 'a'] -= 1;

        if(chars[currChar - 'a']==0){
            count[0] -= 1;
        }

    }

}
