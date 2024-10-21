
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {
    public static String generateMD5Digest(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(message.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message to hash: ");
        String message = scanner.nextLine();
        String md5Digest = generateMD5Digest(message);
        System.out.println("MD5 Digest of the message: " + md5Digest);
        scanner.close();
    }
}

// Enter the message to hash: amar
// MD5 Digest of the message: 36341cbb9c5a51ba81e855523de49dfd
