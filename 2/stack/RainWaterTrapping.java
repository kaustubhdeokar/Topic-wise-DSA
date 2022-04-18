package stack;

public class RainWaterTrapping {

    public int trap() {

	
		int[] height = {1,8,6,2,5,4,8,3,7};
		
        int[] leftLargest = new int[height.length];
        int largest = -1;

        for (int i = 0; i < height.length; i++) {

            if (height[i] > largest)
                leftLargest[i] = -1;
            else
                leftLargest[i] = largest;

            largest = Integer.max(largest, height[i]);
        }

        int[] rightLargest = new int[height.length];
        largest = -1;

        for (int i = height.length - 1; i > -1; i--) {

            if (height[i] > largest)
                rightLargest[i] = -1;
            else
                rightLargest[i] = largest;
            largest = Integer.max(largest, height[i]);

        }

        int trapping = 0;
        for (int i = 0; i < height.length; i++) {
            if (leftLargest[i] != -1 && rightLargest[i] != -1) {
                trapping += Math.min(leftLargest[i], rightLargest[i]) - height[i];
            }
        }
        return trapping;

    }

}

