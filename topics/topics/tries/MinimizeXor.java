package tries;

public class MinimizeXor {
    public int minimizeXor(int num1, int num2) {
        int count = 0;
        int temp = 1<<31-1;
        while(temp>0){
            if((temp&num2)>0) {
                count+=1;
            }
            temp>>=1;
        }

        temp = 1<<31-1;
        int counter = 31;
        int[] expectedNum = new int[32];
        while(temp>0 && count>0){
            if((temp&num1)>0){
                expectedNum[counter-1] = 1;
                count-=1;

            }
            counter-=1;
            temp>>=1;
        }
        int ptr = 0;
        while(count>0 && ptr<32)
        {
            if(expectedNum[ptr]==0)
            {
                expectedNum[ptr] = 1;
                count-=1;
            }
            ptr+=1;
        }

        int result = 0;
        for(int i=0;i<=31;i++){
            if(expectedNum[i]==1){
                result+=(int) Math.pow(2,i);
            }
        }

        return result;
    }
}
