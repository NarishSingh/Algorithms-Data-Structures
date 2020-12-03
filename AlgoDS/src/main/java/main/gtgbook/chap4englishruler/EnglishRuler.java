/*
Example of recursion
english ruler always have inches, half and quarter inches, but follows that structure even lower or higher
it is a self-recursive structure, no matter the level of magnification
 */

package main.gtgbook.chap4englishruler;

public class EnglishRuler {

    /**
     * Draw an english ruler
     *
     * @param nInches     {int} total number of inches to draw
     * @param majorLength {int} major tick length for draw, 1 = inch marks only, 2 = half and inch, 3 = quarter half and
     *                    inch, 4 = eighth quarter half and inch
     */
    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);

        for (int i = 1; i <= nInches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i);
        }
    }

    /**
     * Recursively structures the intervavls for the draw
     *
     * @param centralLength {int} the length to subdivide
     */
    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    /**
     * Draw line w given tick length
     *
     * @param tickLength {int}
     */
    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    /**
     * Draw line w given tick length, with label
     *
     * @param tickLength {int} the length to draw over
     * @param tickLabel  {int} inch labels to print at intervals
     */
    private static void drawLine(int tickLength, int tickLabel) {
        for (int i = 0; i < tickLength; i++) {
            System.out.print("-");
        }

        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {
        drawRuler(12, 4);
    }
}
