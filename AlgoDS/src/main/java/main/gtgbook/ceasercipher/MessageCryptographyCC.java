package main.gtgbook.ceasercipher;

public class MessageCryptographyCC {

    public static void main(String[] args) {
        CeaserCipher c = new CeaserCipher(3);

        System.out.println("Encryption code: " + new String(c.encoder));
        System.out.println("Decryption code: " + new String(c.decoder));

        String msg = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        String coded = c.encrypt(msg);
        System.out.println("Secret: " + coded);

        String original = c.decrypt(coded);
        System.out.println("Original: " + original);
    }
}
