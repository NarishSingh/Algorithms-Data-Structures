package main.hackerrank;

public class staircase {

    static void drawStaircase(int n) {
        StringBuilder scBuild = new StringBuilder(); //sb faster than manual

        //1-n inclusive = stair levels
        for (int i = 1; i <= n; i++) {
            //spaces = n - i
            scBuild.append(" ".repeat(Math.max(0, n - i)));

            //stair/# = i
            scBuild.append("#".repeat(Math.max(0, i)));

            scBuild.append("\n");
        }

        System.out.print(scBuild);
    }

    public static void main(String[] args) {
        int n = 6;

        drawStaircase(n);
    }
}
