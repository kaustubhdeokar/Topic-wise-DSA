package dp.oned;

public class FrogJumps {

    public static void main(String[] args) {
        FrogJumps frogJumps = new FrogJumps();
        System.out.println(frogJumps.frogJumps(new int[]{10, 20, 30, 10}, 4));
        System.out.println(frogJumps.frogJumpsWithK(new int[]{10, 20, 30, 10}, 4, 2));
    }

    public int frogJumps(int[] arr, int N) {
        int[] energySpent = new int[N];
        energySpent[0] = 0;
        energySpent[1] = Math.abs(arr[1] - arr[0]);


        for (int i = 2; i < N; i++) {
            energySpent[i] = Integer.min(
                    energySpent[i - 1] + Math.abs(arr[i] - arr[i - 1]),
                    energySpent[i - 2] + Math.abs(arr[i] - arr[i - 2]));
        }

        for (int e : energySpent) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println(energySpent[energySpent.length - 1]);
        return energySpent[N - 1];
    }

    public int frogJumpsWithK(int[] arr, int N, int k) {
        int[] energySpent = new int[N];
        energySpent[0] = 0;
        for (int i = 0; i < k; i++) {
            energySpent[i] = Math.abs(arr[i] - arr[0]);
        }

        for (int i = k; i < N; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                minEnergy = Math.min(minEnergy,
                        energySpent[i - j] + Math.abs(arr[i] - arr[i - j]));
            }

            energySpent[i] = minEnergy;
        }

        for (int e : energySpent) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println(energySpent[energySpent.length - 1]);

        return energySpent[N - 1];
    }
}
