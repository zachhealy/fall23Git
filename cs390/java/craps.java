package cs390.java;

import java.util.*;

public class craps {
    public static void main(String[] args) {
        int x = 1;
        Scanner input = new Scanner(System.in);
        User user = new User();

        while (x != 0) {
            System.out.println();
            System.out.println("Account Balance: " + user.balance);
            System.out.println("--");
            System.out.println("1 - Bet");
            System.out.println("0 - Exit Game");
            System.out.print("Please enter a number: ");
            x = input.nextInt();

            switch (x) {
                case 1:
                    diceRoll();
                    break;

                default:
                    System.out.println("error, returning to menu");
                    break;
            }
        }
    }

    public static void diceRoll() {
        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            int roll = rand.nextInt(6) + 1;

            switch (roll) {
                case 1:
                    System.out.println("--------");
                    System.out.println("|       |");
                    System.out.println("|   0   |");
                    System.out.println("|       |");
                    System.out.println("--------");
                    break;
                case 2:
                    System.out.println("--------");
                    System.out.println("|  0    |");
                    System.out.println("|       |");
                    System.out.println("|     0 |");
                    System.out.println("--------");
                    break;
                case 3:
                    System.out.println("--------");
                    System.out.println("| 0     |");
                    System.out.println("|   0   |");
                    System.out.println("|     0 |");
                    System.out.println("--------");
                    break;
                case 4:
                    System.out.println("--------");
                    System.out.println("| 0   0 |");
                    System.out.println("|       |");
                    System.out.println("| 0   0 |");
                    System.out.println("--------");
                    break;
                case 5:
                    System.out.println("--------");
                    System.out.println("| 0   0 |");
                    System.out.println("|   0   |");
                    System.out.println("| 0   0 |");
                    System.out.println("--------");
                    break;
                case 6:
                    System.out.println("--------");
                    System.out.println("| 0   0 |");
                    System.out.println("| 0   0 |");
                    System.out.println("| 0   0 |");
                    System.out.println("--------");
                    break;
                default:
                    System.out.println("error, returning to menu");
                    break;
            }
        }

    }

    static class User {
        public double balance;

        public User() {
            balance = 500.00;
        }
    }
}