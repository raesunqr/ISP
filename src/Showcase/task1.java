package Showcase;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by raesun on 4/1/17.
 * A program to demonstrate the use of hashing using MD5, SHA-1 and SHA-256
 * scheme and the MessageDigest class
 */

public class task1 {
    /**
     *
     * @param plainText string that user type in
     * @return hash result using MD5, SHA-1, SHA-256 respectively
     */

    public static String MD5(String plainText) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5.digest(plainText.getBytes("UTF-8"));
            return bytesToHex(messageDigest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String SHA1(String plainText) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = sha1.digest(plainText.getBytes("UTF-8"));
            return bytesToHex(messageDigest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String SHA256(String plainText) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = sha256.digest(plainText.getBytes("UTF-8"));
            return bytesToHex(messageDigest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        /*
        convert a byte to an always 2-character hexadecimal string
         */
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Please type your plaintext:");
        Scanner scan = new Scanner(System.in);
        String pt = scan.next();
        System.out.println("MD5 Hash: "+MD5(pt));
        System.out.println("SHA-1 Hash: "+SHA1(pt));
        System.out.println("SHA-256 Hash: "+SHA256(pt));
    }
}


/* BigInteger number = new BigInteger(messageDigest);//better deal with long data
String hashText = number.toString(16);
//MD5 hash length = 128 bits = 16 bytes = 32 hex digits
while (hashText.length() < 32) {
//zero pad it if want the full 32 chars
hashText = "0" + hashText;
}
return hashText;*/