public class CowsAndBulls{

    public String getHint(String secret, String guess) {
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        StringBuilder answer = new StringBuilder();

        int bulls = 0;

        for(int i=0;i<secret.length();i++){
            
            int secretCurr = Character.getNumericValue(secret.charAt(i));
            int guessCurr = Character.getNumericValue(guess.charAt(i));
            
            if(secretCurr == guessCurr) bulls+=1;

            else{
                secretArr[secretCurr] += 1;
                guessArr[guessCurr] += 1; 
            }
        }

        int cows = 0;

        for(int i=0;i<10;i++){
            cows += Integer.min(secretArr[i], guessArr[i]);
        }

        answer.append(bulls).append("A").append(cows).append("B");
        return answer.toString();
    }
}