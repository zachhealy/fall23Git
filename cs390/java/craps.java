package cs390.java;

import java.util.*;

public class craps {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
            int choice = input.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter your bet amount: $");
                double betAmount = input.nextDouble();

                if (betAmount > balance) {
                    System.out.println("Insufficient balance for this bet.");
                    continue;
                }

                balance -= betAmount;

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
                        balance += betAmount * 2;
                    } else if (sum == 2 || sum == 3 || sum == 12) {
                        System.out.println("You lose on " + betType);

                    } else {
                        point = sum;
                        System.out.println("Point is " + point);
                    }
                } else if (choice == 2 || choice == 4) {
                    if (sum == 7 || sum == 11) {
                        System.out.println("You lose on " + betType);

                    } else if (sum == 2 || sum == 3) {
                        System.out.println("You win on " + betType);
                        balance += betAmount * 2;
                    } else if (sum == 12) {
                        System.out.println("It's a push on " + betType);
                    } else {
                        point = sum;
                        System.out.println("Point is " + point);
                    }
                }

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
        int dieRolls[];
        dieRolls = new int[2];
        for (int i = 0; i < 2; i++) {
            dieRolls[i] = random.nextInt(6) + 1;
        }

        for (int i = 0; i < 2; i++) {
            switch (dieRolls[i]) {
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
        return dieRolls[0] + dieRolls[1];
    }
}
