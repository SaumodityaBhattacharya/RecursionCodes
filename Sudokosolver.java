import java.util.Scanner;

public class Sudokosolver {
    public static boolean Check(int mat[][], int i, int j, int num, int n) {
        // Vertical check
        for (int r = 0; r < n; r++) {
            if (mat[r][j] == num)
                return false;
        }
        // Horizontal Check
        for (int c = 0; c < n; c++) {
            if (mat[i][c] == num)
                return false;
        }
        // Grid checker
        int q = (int) Math.sqrt(n);
        int startRow = (i / q) * q;
        int startCol = (j / q) * q;
        for (int u = startRow; u < startRow + q; u++) {
            for (int v = startCol; v < startCol + q; v++) {
                if (mat[u][v] == num)
                    return false;
            }
        }
        return true;
    }

    public static boolean Sudoko(int mat[][], int i, int j, int n) {
        if (i == n) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(mat[r][c] + " ");
                }
                System.err.println();
            }
        } // End of base case
        if (j == n) {
            return Sudoko(mat, i + 1, 0, n);
        } // To move to next row
        if (mat[i][j] != 0) {
            return Sudoko(mat, i, j + 1, n);
        } // To move to next col
        for (int num = 1; num <= n; num++) {
            if (Check(mat, i, j + 1, num, n)) {
                mat[i][j] = num;
                boolean rec = Sudoko(mat, i, j + 1, n);
                if (rec)
                    return true;
                mat[i][j] = 0; // Backtracking condition
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] mat = new int[n][n];
        // Getting 9X9 array input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = s.nextInt();
            }
        }
        if (!Sudoko(mat, 0, 0, n)) {
            System.out.println("No solution exists!");
        }
        s.close();
    }
}
