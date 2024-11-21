package array.problems;

import java.util.Arrays;

public class SlidingWindow {

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }

        int len = code.length;
        int sum = 0;
        int k1 = k;
        int left = 0, right = 0;
        if (k > 0) {
            right = 1;
            left = 1;
            while (k1-- > 0) {
                sum += code[right];
                right += 1;
            }
        } else {
            right = len - 1;
            left = len - 1;
            while (k1++ < 0) {
                sum += code[left]; //4-1, 4-2,
                left -= 1;
            }
        }

        System.out.println("sum:" + sum + " left:" + left + " right:" + right);
        int[] res = new int[len];
        int resPtr = 0;
        while(resPtr<len){
            res[resPtr++] = sum;
            if(k>0){
                sum -= code[left%len];
                sum += code[right%len];
                right = (right+1)%len;
                left = (left+1)%len;
            }
            else{
                sum += code[left%sum];
                sum -= code[right%len];
                right = (right+1)%len;
                left = (left+1)%len;
            }
            System.out.println("sum:"+sum+" left:"+left+" right:"+right);
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] code = {2,4,9,3};
        int k = -2;
        slidingWindow.decrypt(code, k);
    }
}
