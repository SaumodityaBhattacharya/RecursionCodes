import java.util.Scanner;

public class Recursion {
    public static String moveit(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char ch = s.charAt(0);
        String rest = moveit(s.substring(1));
        if (ch == 'x') {
            return rest + ch;
        } else {
            return ch + rest;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(moveit(s));
        sc.close();
    }
}
