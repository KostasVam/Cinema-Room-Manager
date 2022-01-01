import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int seats = scanner.nextInt();
        int found = 0;
        int count;
        loop: for (int i = 0; i < rows; i++) {
            count = seats;
            for (int j = 0; j < columns; j++) {
                if (array[i][j] == 0) {
                    count--;
                } else {
                    count = seats;
                }
                if (count == 0) {
                    found = i + 1;
                    break loop;
                }
            }
        }
        System.out.println(found);
    }
}