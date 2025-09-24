import java.util.Scanner;

public class Permutation {
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int perm(int n, int r) {
        int N = fact(n);
        int R = fact(n - r);
        return N / R;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();
        System.out.println("Enter the value of r:");
        int r = scanner.nextInt();
        System.out.println("The permutation of the numbers is: " + perm(n, r));
        scanner.close();
    }
}
