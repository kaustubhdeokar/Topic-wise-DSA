/*
ID: kaustub13
LANG: JAVA
PROG: gift1 
*/

/*
https://train.usaco.org/usacoprob2?S=gift1&a=5SRUvnARgfZ
*/
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class gift1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("gift1.in"));
        String input = bufferedReader.readLine();

        StringTokenizer stringTokenizer;
        int numOfPeople = Integer.parseInt(input);

        Map<String, Integer> mapPeopleToTheirBalance = new LinkedHashMap<>();
        for (int i = 0; i < numOfPeople; i++) {
            mapPeopleToTheirBalance.put(bufferedReader.readLine(), 0);
        }

        for (int i = 0; i < numOfPeople; i++) {
            String giver = bufferedReader.readLine();
            String giftDescription = bufferedReader.readLine();
            stringTokenizer = new StringTokenizer(giftDescription);

            int amountDistributed = Integer.parseInt(stringTokenizer.nextToken());
            int distributedAmongPeople = Integer.parseInt(stringTokenizer.nextToken());

            int amountForEach;

            amountForEach = calculateAmountForEach(amountDistributed, distributedAmongPeople);

            updateBalance(mapPeopleToTheirBalance,giver,-amountDistributed);

            for(int j=0;j<distributedAmongPeople;j++){
                String receiver = bufferedReader.readLine();
                updateBalance(mapPeopleToTheirBalance,receiver,amountForEach);
            }
            if(distributedAmongPeople!=0){
                updateBalance(mapPeopleToTheirBalance,giver,amountDistributed - (amountDistributed/distributedAmongPeople)*distributedAmongPeople);
            }
        }


        PrintWriter printWriter = new PrintWriter(new FileWriter("gift1.out"));
        Set<Map.Entry<String, Integer>> entries = mapPeopleToTheirBalance.entrySet();
        entries.forEach(entry-> printWriter.println(entry.getKey()+" "+entry.getValue()));
        printWriter.close();

    }

    private static int calculateAmountForEach(int amountDistributed, int distributedAmongPeople) {
        int amountForEach;
        if(distributedAmongPeople ==0){
            amountForEach = 0;
        }
        else{
            amountForEach = amountDistributed / distributedAmongPeople;
        }
        return amountForEach;
    }

    private static void updateBalance(Map<String, Integer> mapPeopleToTheirBalance, String giver, int updateBy) {
        Integer existingBalance = mapPeopleToTheirBalance.get(giver);
        mapPeopleToTheirBalance.put(giver,existingBalance+updateBy);
    }

}

/*

Executing...
   Test 1: TEST OK [0.317 secs, 28764 KB]
   Test 2: TEST OK [0.273 secs, 28460 KB]
   Test 3: TEST OK [0.271 secs, 28612 KB]
   Test 4: TEST OK [0.271 secs, 28320 KB]
   Test 5: TEST OK [0.266 secs, 28624 KB]
   Test 6: TEST OK [0.264 secs, 28712 KB]
   Test 7: TEST OK [0.322 secs, 29128 KB]
   Test 8: TEST OK [0.280 secs, 28524 KB]
   Test 9: TEST OK [0.278 secs, 28652 KB]
   
   */

