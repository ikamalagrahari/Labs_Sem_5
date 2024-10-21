import java.util.Scanner;

public class CaesarCipher {

    public static String applyCaesarCipher(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int offset = c - base;
                int newOffset = encrypt ? (offset + shift) % 26 : (offset - shift + 26) % 26;
                result.append((char) (base + newOffset));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();
        
        System.out.print("Encrypt (e) or Decrypt (d)? ");
        char choice = scanner.next().charAt(0);
        
        boolean encrypt = (choice == 'e' || choice == 'E');
        String result = applyCaesarCipher(text, shift, encrypt);
        
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}


// Enter the text: amar
// Enter the shift value: 3
// Encrypt (e) or Decrypt (d)? e
// Result: dpdu
// Encrypt (e) or Decrypt (d)? d
// Result: xjxo