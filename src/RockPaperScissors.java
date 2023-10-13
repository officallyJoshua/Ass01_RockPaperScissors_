mport java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;

        do {
            char playerAChoice = getPlayerChoice("Player A");
            char playerBChoice = getPlayerChoice("Player B");

            displayResult(playerAChoice, playerBChoice);

            System.out.print("Play again? (Y/N): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');
    }

    private static char getPlayerChoice(String playerName) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        boolean validChoice;

        do {
            System.out.print(playerName + ", choose Rock (R), Paper (P), or Scissors (S): ");
            choice = scanner.next().charAt(0);
            choice = Character.toLowerCase(choice); // Convert to lowercase

            validChoice = choice == 'r' || choice == 'p' || choice == 's';
            if (!validChoice) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (!validChoice);

        return choice;
    }

    private static void displayResult(char playerAChoice, char playerBChoice) {
        System.out.print("Player A chose " + playerAChoice + " and Player B chose " + playerBChoice + ". Result: ");

        if (playerAChoice == playerBChoice) {
            System.out.println("It's a Tie!");
        } else if ((playerAChoice == 'r' && playerBChoice == 's') ||
                (playerAChoice == 'p' && playerBChoice == 'r') ||
                (playerAChoice == 's' && playerBChoice == 'p')) {
            System.out.println("Player A wins! " + getWinningPhrase(playerAChoice));
        } else {
            System.out.println("Player B wins! " + getWinningPhrase(playerBChoice));
        }
    }

    private static String getWinningPhrase(char choice) {
        if (choice == 'r') {
            return "Rock beats Scissors";
        } else if (choice == 'p') {
            return "Paper covers Rock";
        } else {
            return "Scissors cut Paper";
        }
    }
}