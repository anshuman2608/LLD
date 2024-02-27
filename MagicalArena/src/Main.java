import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting the game Magical Arena");

        boolean playAgain = true;
        while (playAgain) {
            playGame(scanner);
            System.out.println("Do you want to play again? (yes/no):");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        // Get data for Player A
        System.out.println("Enter data for Player A:");
        int healthA = getInput(scanner, "Health:");
        int strengthA = getInput(scanner, "Strength:");
        int attackA = getInput(scanner, "Attack:");
        Player playerA = new Player(healthA, strengthA, attackA);

        // Get data for Player B
        System.out.println("Enter data for Player B:");
        int healthB = getInput(scanner, "Health:");
        int strengthB = getInput(scanner, "Strength:");
        int attackB = getInput(scanner, "Attack:");
        Player playerB = new Player(healthB, strengthB, attackB);

        // Initialize dice
        Die attackingDie = new Die(6);
        Die defendingDie = new Die(6);

        // Start the game
        MagicalArena arena = new MagicalArena(playerA, playerB, attackingDie, defendingDie);
        arena.playMatch();
    }

    private static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}