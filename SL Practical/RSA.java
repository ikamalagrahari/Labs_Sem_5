import java.util.Scanner;

public class RSA {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static int modInverse(int e, int phi) {
        int t1 = 0, t2 = 1, r1 = phi, r2 = e;
        while (r2 != 0) {
            int q = r1 / r2;
            int r = r1 - q * r2;
            r1 = r2;
            r2 = r;

            int t = t1 - q * t2;
            t1 = t2;
            t2 = t;
        }
        return (r1 == 1) ? (t1 < 0 ? t1 + phi : t1) : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the secret message (plaintext) to encrypt: ");
        long pt = scanner.nextLong();

        System.out.print("Enter a prime number P: ");
        int p = scanner.nextInt();

        System.out.print("Enter a prime number Q: ");
        int q = scanner.nextInt();

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        int e = 0;
        for (int i = 2; i < phi; i++) {
            if (gcd(i, phi) == 1) {
                e = i;
                break;
            }
        }

        int d = modInverse(e, phi);
        if (d == -1) {
            System.out.println("No modular inverse found for the given e.");
            scanner.close();
            return;
        }

        long ct = modExp(pt, e, n);

        System.out.println("\nPublic Key (n, e) = (" + n + ", " + e + ")");
        System.out.println("Private Key (d) = " + d);
        System.out.println("Ciphertext (CT): " + ct);

        long pt2 = modExp(ct, d, n);
        System.out.println("\nDecrypting...");
        System.out.println("Decrypted Plaintext (PT): " + pt2);

        scanner.close();
    }
}


// Enter the secret message (plaintext) to encrypt: 2345
// Enter a prime number P: 7
// Enter a prime number Q: 9

// Public Key (n, e) = (63, 5)
// Private Key (d) = 29
// Ciphertext (CT): 56

// Decrypting...
// Decrypted Plaintext (PT): 14