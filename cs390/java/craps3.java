package cs390.java;

import java.util.Random;
import java.util.Scanner;

public class craps3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bankroll = 1000; // Starting bankroll

        System.out.println("Welcome to Craps Simulation!");
        System.out.println("Starting bankroll: " + bankroll);

        while (bankroll > 0) {
            System.out.print("Enter your bet amount: ");
            int betAmount = scanner.nextInt();

            if (betAmount > bankroll) {
                System.out.println("You can't bet more than your bankroll.");
                continue;
            }

            System.out.println();
            System.out.println("Betting Types:");
            System.out.println("-------");
            System.out.println("1. Pass Line");
            System.out.println("2. Don't Pass");
            System.out.println("3. Come");
            System.out.println("4. Don't Come");
            System.out.print("Choose your bet type: ok");
            int betType = scanner.nextInt();

            int diceSum = rollDice(random);
            System.out.println("You rolled: " + diceSum);

            switch (betType) {
                case 1: // Pass Line
                    if (diceSum == 7 || diceSum == 11) {
                        System.out.println("You win!");
                        bankroll += betAmount;
                    } else if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
                        System.out.println("You lose.");
                        bankroll -= betAmount;
                    } else {
                        int point = diceSum;
                        System.out.println("Point is set to " + point);
                        playPointPhase(random, bankroll, betAmount, point);
                    }
                    break;

                case 2: // Don't Pass
                    if (diceSum == 2 || diceSum == 3) {
                        System.out.println("You win!");
                        bankroll += betAmount;
                    } else if (diceSum == 7 || diceSum == 11) {
                        System.out.println("You lose.");
                        bankroll -= betAmount;
                    } else if (diceSum == 12) {
                        System.out.println("It's a tie (push).");
                    } else {
                        int point = diceSum;
                        System.out.println("Point is set to " + point);
                        playPointPhase(random, bankroll, betAmount, point);
                    }
                    break;

                case 3:
                    int comePoint = rollDice(random);
                    System.out.println("Come point is set to " + comePoint);
                    playComePointPhase(random, bankroll, betAmount, comePoint);
                    break;

                case 4:
                    int dontComePoint = rollDice(random);
                    System.out.println("Don't come point is set to " + dontComePoint);
                    playDontComePointPhase(random, bankroll, betAmount, dontComePoint);
                    break;

                default:
                    System.out.println("Invalid bet type.");
            }

            System.out.println("Bankroll: " + bankroll);
        }

        System.out.println("Game over. You're out of money.");
    }

    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }

    public static void playPointPhase(Random random, int bankroll, int betAmount, int point) {
        while (true) {
            int diceSum = rollDice(random);
            System.out.println("You rolled: " + diceSum);

            if (diceSum == 7) {
                System.out.println("You lose.");
                bankroll -= betAmount;
                break;
            } else if (diceSum == point) {
                System.out.println("You win!");
                bankroll += betAmount;
                break;
            }
        }
    }

    public static void playComePointPhase(Random random, int bankroll, int betAmount, int comePoint) {
        while (true) {
            int diceSum = rollDice(random);
            System.out.println("You rolled: " + diceSum);

            if (diceSum == 7) {
                System.out.println("You lose.");
                bankroll -= betAmount;
                break;
            } else if (diceSum == comePoint) {
                System.out.println("You win!");
                bankroll += betAmount;
                break;
            }
        }
    }

    public static void playDontComePointPhase(Random random, int bankroll, int betAmount, int dontComePoint) {
        while (true) {
            int diceSum = rollDice(random);
            System.out.println("You rolled: " + diceSum);

            if (diceSum == 7) {
                System.out.println("You win!");
                bankroll += betAmount;
                break;
            } else if (diceSum == dontComePoint) {
                System.out.println("You lose.");
                bankroll -= betAmount;
                break;
            }
        }
    }

}
