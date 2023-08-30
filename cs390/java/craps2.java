package cs390.java;

import java.util.*;

public class craps2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        double balance = 100.0;
        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.println("Balance: $" + balance);
            System.out.println("1. Bet on Pass");
            System.out.println("2. Bet on Don't Pass");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter your bet amount: $");
                double betAmount = scanner.nextDouble();

                if (betAmount > balance) {
                    System.out.println("Insufficient balance for this bet.");
                    continue;
                }

                int point = -1;
                int sum = rollDice(random);
                String betType = (choice == 1) ? "Pass" : "Don't Pass";
                System.out.println("Initial roll: " + sum);

                if (sum == 7 || sum == 11) {
                    System.out.println("You win on " + betType);
                    balance += betAmount;
                } else if (sum == 2 || sum == 3 || sum == 12) {
                    System.out.println("You lose on " + betType);
                    balance -= betAmount;
                } else {
                    point = sum;
                    System.out.println("Point is " + point);
                }

                while (point != -1) {
                    sum = rollDice(random);
                    System.out.println("Next roll: " + sum);
                    if (sum == 7) {
                        System.out.println("You lose on " + betType);
                        balance -= betAmount;
                        break;
                    } else if (sum == point) {
                        System.out.println("You win on " + betType);
                        balance += betAmount;
                        break;
                    }
                }
            } else if (choice == 3) {
                continuePlaying = false;
                System.out.println("Thank you for playing!");
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }

            if (balance <= 0) {
                System.out.println("You are out of balance. Game over.");
                break;
            }
        }
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;

        switch (die1) {
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
        switch (die2) {
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

        return die1 + die2;
    }
}
