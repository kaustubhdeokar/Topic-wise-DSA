/*

The questions states that, for an given array, output the xor of all subarrays. 
For example, if A = [3, 4, 5] :

Subarray    Operation   Result
3       None            3
4       None            4
5       None            5
3,4   3 XOR 4         7
4,5   4 XOR 5         1
3,4,5    3 XOR 4 XOR 5   2

Now we take the resultant values and XOR them together:

3 ⊕ 4 ⊕ 5 ⊕ 7 ⊕ 1⊕ 2 = 6 we will return 6.



Approach:-

EVEN. 

The pattern that we see is for even number of elements, the xor is always 0

[1,2,3,4]

Size 1 -> 1 2 3 4
Size 2 -> 1 2, 2 3, 3 4 (2,3 cancel each other out -> 1 AND 4  REMAIN)
Size 3 -> 1 2 3, 2 3 4 (2,3 cancel each other out -> 1 AND 4  REMAIN)
Size 4 -> 1 2 3 4 

SIZE 1 AND SIZE 4 CANCEL EACH OTHER. 

SIZE 2 AND SIZE 3 CANCEL EACH OTHER . 

THIS IS TRUE FOR ALL i & it's complement (N) (1&6, 2&5 3&4 ..) 

ODD. 

[1,2,3,4,5]

FOLLOWING THE SIMILAR APPROACH AS ABOVE, THE EVEN PLACES (1-INDEX ARRAY) CANCEL EACH OTHER OUT. 

hence we can just sum, odd places. 


*/

public class XORSubarrays {
    public int solve(int[] A) {
        if(A.length%2==0)
        return 0;
        else{
            int xor = 0;
            for(int i=0;i<A.length;i+=2){
                // System.out.print(A[i]);
                xor^=A[i];
            }
            return xor;
        }
    }
}

