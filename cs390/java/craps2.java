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
            System.out.println("3. Bet on Come");
            System.out.println("4. Bet on Don't Come");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter your bet amount: $");
                double betAmount = scanner.nextDouble();

                if (betAmount > balance) {
                    System.out.println("Insufficient balance for this bet.");
                    continue;
                }

                int point = -1;
                int sum = rollDice(random);
                String betType = "";

                switch (choice) {
                    case 1:
                        betType = "Pass";
                        break;
                    case 2:
                        betType = "Don't Pass";
                        break;
                    case 3:
                        betType = "Come";
                        break;
                    case 4:
                        betType = "Don't Come";
                        break;
                }

                System.out.println("Initial roll: " + sum);

                if (choice == 1 || choice == 3) {
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
                } else if (choice == 2 || choice == 4) {
                    if (sum == 7 || sum == 11) {
                        System.out.println("You lose on " + betType);
                        balance -= betAmount;
                    } else if (sum == 2 || sum == 3) {
                        System.out.println("You win on " + betType);
                        balance += betAmount;
                    } else if (sum == 12) {
                        System.out.println("It's a push on " + betType);
                    } else {
                        point = sum;
                        System.out.println("Point is " + point);
                    }
                }
                // NEED MORE LOGIC HERE

            } else if (choice == 5) {
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
