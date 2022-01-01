package cinema;

import java.util.Scanner;

public class Cinema {
    final static int  SEATS = 60;
    static int currentIncome = 0;
    static int purchasedTickets = 0;
    static int firstClassTickets;
    static int secondClassTickets;
    static int totalIncome;

    public static void main(String[] args) {
        int rows = rows();
        int seatsPerRow = seatPerRow();
        String[][] array = new String[rows + 1][seatsPerRow + 1];

        initializeCinema(array, rows, seatsPerRow);
        findTotalTickets(rows, seatsPerRow);
        findTotalIncome();

        int choice = -1;
        while (choice != 0) {
            choice = menu();
            switch(choice) {
                case 1:
                    printCinema(array, rows, seatsPerRow);
                    break;
                case 2:
                    buyTicket(array, rows, seatsPerRow);
                    break;
                case 3:
                    statistics();
                    break;
                case 0:
                    choice = 0;
            }
        }
    }

    public static int rows() {
        System.out.println("Enter the number of rows:");
        return new Scanner(System.in).nextInt();
    }

    public static int seatPerRow() {
        System.out.println("Enter the number of seats in each row:");
        return new Scanner(System.in).nextInt();
    }

    public static int menu() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
        return new Scanner(System.in).nextInt();
    }

    public static void initializeCinema(String[][] array, int rows, int seatsPerRow) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seatsPerRow; j++) {
                if (i == 0 && j == 0) {
                    array[i][j] = "  ";
                } else if (i == 0) {
                    array[i][j] = j + " ";
                } else if (j == 0) {
                    array[i][j] = i + " ";
                } else {
                    array[i][j] = "S ";
                }
            }
        }
    }

    public static void findTotalTickets(int rows, int seatsPerRow) {
        firstClassTickets = rows / 2 * seatsPerRow;
        secondClassTickets = rows * seatsPerRow - firstClassTickets;
    }

    public static void findTotalIncome() {
        if (firstClassTickets + secondClassTickets <= SEATS) {
            totalIncome = (firstClassTickets + secondClassTickets) * 10;
        } else {
            totalIncome = firstClassTickets * 10 + secondClassTickets * 8;
        }
    }

    public static void printCinema(String[][] array, int rows, int seatsPerRow) {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seatsPerRow; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
    }

    public static void buyTicket(String[][] array, int rows, int seatsPerRow) {
        int row = row(rows);
        int seat = seat(seatsPerRow);
        if (row == -1 || seat == -1) {
            System.out.println("Wrong input!\n");
            buyTicket(array, rows, seatsPerRow);
        } else if (array[row][seat] == "B ") {
            System.out.println("That ticket has already been purchased!\n");
            buyTicket(array, rows, seatsPerRow);
        } else {
            printPrice(row, rows, seatsPerRow);
            array[row][seat] = "B ";
            purchasedTickets++;
        }
    }

    public static int row(int rows) {
        System.out.println("Enter a row number:");
        int row = new Scanner(System.in).nextInt();
        if (row <= 0 || row > rows) {
            return -1;
        } else {
            return row;
        }
    }

    public static int seat(int seatsPerRow) {
        System.out.println("Enter a seat number in that row:");
        int seat = new Scanner(System.in).nextInt();
        if (seat <= 0 || seat > seatsPerRow) {
            return -1;
        } else {
            return seat;
        }
    }

    public static void printPrice(int row, int rows, int seatsPerRow) {
        if (seatsPerRow * rows < SEATS || row <= rows / 2) {
            System.out.println("Ticket price: $10\n");
            currentIncome += 10;
        } else {
            System.out.println("Ticket price: $8\n");
            currentIncome += 8;
        }
    }

    public static void statistics() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", (float)purchasedTickets / (firstClassTickets + secondClassTickets) * 100);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}