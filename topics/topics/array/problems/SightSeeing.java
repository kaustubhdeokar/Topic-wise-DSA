package array.problems;

class SightSeeing{

    public static void main(String[] args) {
        
        SightSeeing seeing = new SightSeeing();
        int[] values = {8, 1, 5, 2, 6};
        int result = seeing.maxScoreSightseeingPair(values);
        System.out.println(result);  // Expected: 11

    }

    public int maxScoreSightseeingPair(int[] values) {
        /*      
            8  1  5  2  6
            0  1  2  3  4

values[i]+i 8  2  7  5  
values[j]-j    0  3 -1  2
        */

        int maxIVal = values[0];
        int maxScore = -1001;

        for(int i=1;i<values.length;i++){
            
            maxScore = Integer.max(maxScore, maxIVal + values[i] - i);
            maxIVal = Integer.max(maxIVal, values[i]+i);
        }

        return maxScore;

    }

}
