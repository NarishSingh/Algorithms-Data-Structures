package main.hackerrank;

public class plusminosratios {

    static void plusMinus(int[] arr) {
        int n = arr.length;
        int posCt = 0;
        int negCt = 0;
        int zCt = 0;

        for (int i : arr) {
            if (i != 0) {
                switch (Integer.signum(i)) {
                    case -1:
                        negCt++;
                        break;
                    case 1:
                        posCt++;
                        break;
                    default:
                        throw new IllegalArgumentException("Not a number");
                }
            } else {
                zCt++;
            }
        }

        System.out.printf("%.6f%n", (double) posCt / n);
        System.out.printf("%.6f%n", (double) negCt / n);
        System.out.printf("%.6f%n", (double) zCt / n);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, 3, -9, 0, 4, 1};

        plusMinus(arr);
    }
}
