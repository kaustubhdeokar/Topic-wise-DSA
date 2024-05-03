package recursion;

class LetterCombinationsLeetcode {
    public List<String> letterCombinations(String digits) {
        HashMap<String,String> mapNumToLetter = new HashMap<>();
        
        mapNumToLetter.put("2","abc");
        mapNumToLetter.put("3","def");
        mapNumToLetter.put("4","ghi");
        mapNumToLetter.put("5","jkl");
        mapNumToLetter.put("6","mno");
        mapNumToLetter.put("7","pqrs");
        mapNumToLetter.put("8","tuv");
        mapNumToLetter.put("9","wxyz");
       
        return combinations("",digits,mapNumToLetter);
        
    }
    
    public List<String> combinations(String processed, String unprocessed, HashMap<String,String> map){
        if(unprocessed.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            if(!processed.isEmpty())
                ans.add(processed);
            return ans;
        }
        
        String currDigit = String.valueOf(unprocessed.charAt(0));
        String letters = map.get(currDigit);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<letters.length();i++){
            ans.addAll(combinations(processed+String.valueOf(letters.charAt(i)),unprocessed.substring(1),map));
        }
        return ans;
    }
    
}
