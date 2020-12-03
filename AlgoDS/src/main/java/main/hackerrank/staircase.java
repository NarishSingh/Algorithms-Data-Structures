package main.hackerrank;

public class staircase {

    static void drawStaircase(int n) {
        StringBuilder scBuild = new StringBuilder(); //sb faster than manual

        //1-n inclusive = stair levels
        for (int i = 1; i <= n; i++) {
            //spaces = n - i
            for (int j = 0; j < n - i; j++) {
                scBuild.append(" ");
            }

            //stair/# = i
            for (int j = 0; j < i; j++) {
                scBuild.append("#");
            }

            scBuild.append("\n");
        }

        System.out.print(scBuild.toString());
    }

    public static void main(String[] args) {
        int n = 6;

        drawStaircase(n);
    }
}
