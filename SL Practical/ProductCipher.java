import java.util.*;

public class ProductCipher {
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String columnarTransposition(String text, String key) {
        int[] keyOrder = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyOrder[i] = key.charAt(i) - '0';
        }
        Arrays.sort(keyOrder);

        StringBuilder[] columns = new StringBuilder[key.length()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new StringBuilder();
        }

        for (int i = 0; i < text.length(); i++) {
            columns[i % key.length()].append(text.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (int index : keyOrder) {
            result.append(columns[index]);
        }

        return result.toString();
    }

    public static String productCipherEncrypt(String plaintext, int caesarShift, String transpositionKey) {
        String substitutedText = caesarCipher(plaintext, caesarShift);
        return columnarTransposition(substitutedText, transpositionKey);
    }

    public static String productCipherDecrypt(String ciphertext, int caesarShift, String transpositionKey) {
        int[] keyOrder = new int[transpositionKey.length()];
        for (int i = 0; i < transpositionKey.length(); i++) {
            keyOrder[i] = transpositionKey.charAt(i) - '0';
        }

        Arrays.sort(keyOrder);
        StringBuilder[] columns = new StringBuilder[transpositionKey.length()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new StringBuilder();
        }

        int numRows = ciphertext.length() / transpositionKey.length();
        int remainder = ciphertext.length() % transpositionKey.length();

        int start = 0;
        for (int index : keyOrder) {
            int length = index < remainder ? numRows + 1 : numRows;
            columns[index].append(ciphertext, start, start + length);
            start += length;
        }

        StringBuilder transposedText = new StringBuilder();
        for (int i = 0; i < numRows + (remainder > 0 ? 1 : 0); i++) {
            for (StringBuilder column : columns) {
                if (i < column.length()) {
                    transposedText.append(column.charAt(i));
                }
            }
        }

        return caesarCipher(transposedText.toString(), -caesarShift);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter Caesar shift: ");
        int caesarShift = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter transposition key: ");
        String transpositionKey = scanner.nextLine();

        String ciphertext = productCipherEncrypt(plaintext, caesarShift, transpositionKey);
        System.out.println("\nCiphertext: " + ciphertext);

        String decryptedText = productCipherDecrypt(ciphertext, caesarShift, transpositionKey);
        System.out.println("\nDecrypted Text: " + decryptedText);

        scanner.close();
    }
}

// Enter the plaintext: amar
// Enter Caesar shift: 7
// Enter transposition key: 3221     // Write it only 

// Ciphertext: thhy

// Decrypted Text: mar