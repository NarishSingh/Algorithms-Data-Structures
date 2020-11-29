/*
Use Strings and Char arrays to encode and decode msgs

Using wraparound the c.cipher shifts chars down by an arbitrary number to encode and decode messages

this will use an arb rotation, specified in the ctor
-> index + rotation % 26 for encoding
-> i - r % 26 for decoding
 */
package main.gtgbook.chap3ceasercipher;

public class CeaserCipher {

    //2 char arrays to store the alphabet with rotation
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    /**
     * ctor to init encrypt and decrypt arrays
     *
     * @param r {int} the rotation, a char offset for the alphabet used
     */
    public CeaserCipher(int r) {
        //ensure we stay within capital letters of alphabet
        if (r > 26) {
            r %= 26;
        }

        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + r) % 26);
            decoder[i] = (char) ('A' + (i - r + 26) % 26); //add 26 after subtraction to ensure wrap around
        }
    }

    /*methods*/

    /**
     * encrypt a message
     *
     * @param msg {String} plaintext message
     * @return {String} ciphertext
     */
    public String encrypt(String msg) {
        return transform(msg, encoder);
    }

    /**
     * Decrypt a message
     *
     * @param secret {String} ciphertext
     * @return {String} plaintext
     */
    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    /**
     * Perform the en/decryption on a string
     *
     * @param original {String} plaintext or ciphertext message
     * @param code     {char[]} the translated alphabet to use for algorithm
     * @return {String} the en/decrypted message
     */
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();

        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }

        return new String(msg);
    }
}
