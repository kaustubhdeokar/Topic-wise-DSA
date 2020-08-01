import java.util.Scanner;

public class Carvans {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while (testCases > 0) {
            int carsAchievingMaxSpeed = 1;
            int numberOfCars = scan.nextInt();
            int[] cars = new int[numberOfCars];

            for (int i = 0; i < numberOfCars; i++)
                cars[i] = scan.nextInt();

            if (numberOfCars !=1){
                int maxSpeed = cars[0];
                for (int j = 1; j < numberOfCars; j++) {
                    if(cars[j]<=maxSpeed) {
                        carsAchievingMaxSpeed += 1;
                       if(cars[j]<maxSpeed)
                        maxSpeed = cars[j];
                    }
                }
            }
            System.out.println(carsAchievingMaxSpeed);
            testCases -= 1;
        }

    }
}
