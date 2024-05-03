package stack;

public class RainWaterTrapping {

    public int trap() {

	
	int[] leftMaxArr = new int[height.length]; 
        int[] rightMaxArr = new int[height.length];

        //for every building calculate the maximum left & maximum right value,
        //minimum of that will be the sealing of the water for every building.

        int len = height.length;
        
        int leftMax = height[0];
        for(int i=0;i<height.length;i++){
            leftMax = Integer.max(leftMax, height[i]);
            leftMaxArr[i] = leftMax;
        }

        int rightMax = height[len-1];
        for(int i=len-1;i>=0;i--){
            rightMax = Integer.max(rightMax, height[i]);
            rightMaxArr[i] = rightMax;
        }

        int total = 0;
        for(int i=0;i<len;i++){
            total += Integer.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return total;

    }

}

