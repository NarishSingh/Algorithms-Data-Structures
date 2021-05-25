package main.codewars;

public class reverseWords {

    /**
     * reverses each word in the string. All spaces in the string will be retained.
     *
     * @param original any string input, typically containing spaces
     * @return string with words reversed
     */
    public static String reverseWordsInString(final String original) {
        //split the sentence String into an array of words as String
        String[] words = original.split(" ");
        StringBuilder reversed = new StringBuilder();

        //iterate through the words array
        for (String word : words) {
            char[] letters = word.toCharArray(); //dump each word to a char array

            //reverse in place by iterating until the middle, swapping letters from front to back
            for (int j = 0; j < letters.length / 2; j++) {
                char fromBack = letters[letters.length - 1 - j]; //temp store back char

                letters[letters.length - 1 - j] = letters[j];
                letters[j] = fromBack;
            }

            reversed.append(String.copyValueOf(letters)).append(" ");
        }

        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString("The quick brown fox jumps over the lazy dog."));
        System.out.println(reverseWordsInString("apple"));
        System.out.println(reverseWordsInString("a b c d"));
        System.out.println(reverseWordsInString("double  spaced  words"));
        System.out.println(reverseWordsInString("   ")); // FIXME: 5/25/2021 need to solve the all spaces issue, .trim() is the problem
    }
}
