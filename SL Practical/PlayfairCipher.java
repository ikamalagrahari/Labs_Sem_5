import java.util.*;

public class PlayfairCipher {
    public static char[][] createMatrix(String key) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder uniqueKey = new StringBuilder(key.toUpperCase() + alphabet);
        Set<Character> charSet = new LinkedHashSet<>();

        for (char c : uniqueKey.toString().toCharArray()) {
            if (Character.isLetter(c)) {
                charSet.add(c == 'J' ? 'I' : c); // Replace J with I
            }
        }

        for (char c : charSet) {
            uniqueKey.append(c);
        }

        char[][] matrix = new char[5][5];
        int index = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (index < uniqueKey.length()) {
                    matrix[i][j] = uniqueKey.charAt(index++);
                }
            }
        }
        return matrix;
    }

    public static int[] findPosition(char[][] matrix, char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static String prepare(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(Character.toUpperCase(c) == 'J' ? 'I' : Character.toUpperCase(c));
            }
        }
        for (int i = 0; i < result.length(); i += 2) {
            if (i + 1 == result.length() || result.charAt(i) == result.charAt(i + 1)) {
                result.insert(i + 1, 'X');
            }
        }
        return result.length() % 2 != 0 ? result.append('X').toString() : result.toString();
    }

    public static String encrypt(char[][] matrix, String plaintext) {
        String prepared = prepare(plaintext);
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < prepared.length(); i += 2) {
            int[] pos1 = findPosition(matrix, prepared.charAt(i));
            int[] pos2 = findPosition(matrix, prepared.charAt(i + 1));

            if (pos1[0] == pos2[0]) {
                ciphertext.append(matrix[pos1[0]][(pos1[1] + 1) % 5]);
                ciphertext.append(matrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                ciphertext.append(matrix[(pos1[0] + 1) % 5][pos1[1]]);
                ciphertext.append(matrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                ciphertext.append(matrix[pos1[0]][pos2[1]]);
                ciphertext.append(matrix[pos2[0]][pos1[1]]);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(char[][] matrix, String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            int[] pos1 = findPosition(matrix, ciphertext.charAt(i));
            int[] pos2 = findPosition(matrix, ciphertext.charAt(i + 1));

            if (pos1[0] == pos2[0]) {
                plaintext.append(matrix[pos1[0]][(pos1[1] + 4) % 5]);
                plaintext.append(matrix[pos2[0]][(pos2[1] + 4) % 5]);
            } else if (pos1[1] == pos2[1]) {
                plaintext.append(matrix[(pos1[0] + 4) % 5][pos1[1]]);
                plaintext.append(matrix[(pos2[0] + 4) % 5][pos2[1]]);
            } else {
                plaintext.append(matrix[pos1[0]][pos2[1]]);
                plaintext.append(matrix[pos2[0]][pos1[1]]);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        String key = "KEYWORD";
        char[][] matrix = createMatrix(key);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        String encrypted = encrypt(matrix, plaintext);
        String decrypted = decrypt(matrix, encrypted);

        System.out.println("\nPlaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}

// Enter the plaintext: amar

// Plaintext: amar
// Encrypted: BLBD
// Decrypted: AMAR