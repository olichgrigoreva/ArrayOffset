import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileInputStream("input.txt"))) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] array = new int[row][col];

            array = arrayInit(sc, row, col, array);
            print(array);

            System.out.println();
            array = toLeft(array);
            print(array);

        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public static int[][] toLeft(int[][] array) {
        int rowLength = array.length;
        int colLength = array[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (col == 0) {
                    array[row][col] = array[row][colLength - 1];
                }
                if (col == colLength - 1) {
                    array[row][col] = 0;
                } else {
                    array[row][col] = array[row][col + 1];
                }
            }
        }
        return array;
    }

    public static void print(int[][] array) {
        int col = array[0].length;
        for (int[] row : array) {
            for (int j = 0; j < col; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] arrayInit(Scanner sc, int row, int col, int[][] array) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }
}
