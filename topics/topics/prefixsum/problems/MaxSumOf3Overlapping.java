package prefixsum.problems;

public class MaxSumOf3Overlapping {
    public static void main(String[] args) {
        int[] arr;
        int k;
//       arr = new int[]{1, 2, 1, 2, 6, 7, 5, 1};
//       k = 2;
        arr = new int[]{4, 5, 10, 6, 11, 17, 4, 11, 1, 3};
        k = 1;
        MaxSumOf3Overlapping maxSumOf3Overlapping = new MaxSumOf3Overlapping();
        maxSumOf3Overlapping.solve(arr, k);
    }

    private void solve(int[] nums, int k) {
        int n = nums.length;

        int[] valueOfMaxSubarray = new int[nums.length];
        int[] idxOfMaxSubarray = new int[nums.length];
        int maxSubarrayVal = 0;
        int curr = 0;
        int k1 = 0;
        int i = nums.length - 1;
        while (k1 < k) {
            curr += nums[i];
            i -= 1;
            k1 += 1;
        }
        valueOfMaxSubarray[i + 1] = curr;
        idxOfMaxSubarray[i + 1] = i + 1; // index of max subarry

        maxSubarrayVal = curr;
        int last = nums.length - 1;
        while (i >= 0) {
            curr += nums[i];
            curr -= nums[last];
            if (curr >= maxSubarrayVal) {
                idxOfMaxSubarray[i] = i;
                maxSubarrayVal = curr;
            } else {
                idxOfMaxSubarray[i] = idxOfMaxSubarray[i + 1];
            }
            valueOfMaxSubarray[i] = maxSubarrayVal;
            last -= 1;
            i -= 1;
        }


        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (i = 1; i < n; i++) {
            prefix[i] = nums[i];
            prefix[i] += prefix[i - 1];
        }

        int sum = 0;
        int maxi = -1, maxj = -1, maxk = -1;
        for (i = 0; i < n; i++) {
            for (int j = i + k; j < n; j++) {
                if ((n - (j + k)) < k) break;
                int maxSubarrayAfterJWindow = valueOfMaxSubarray[j + k];
                int iSum = prefix[i + k - 1] - (i == 0 ? 0 : prefix[i - 1]);
                int jSum = prefix[j + k - 1] - prefix[j - 1];
                int currSum = iSum + jSum + maxSubarrayAfterJWindow;
                if (currSum > sum) {
                    sum = currSum;
                    maxk = idxOfMaxSubarray[j + k];
                    maxj = j;
                    maxi = i;
                }

            }
        }

        System.out.println(sum + ":" + maxi + ":" + maxj + ":" + maxk);

    }


}
