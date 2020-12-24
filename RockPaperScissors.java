import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors implements Runnable {

    private GameModel gameModel;

    private Random random;

    public static void main(String[] args) {
        new RockPaperScissors().run();
    }

    public RockPaperScissors() {
        this.random = new Random();
        this.gameModel = new GameModel();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        char inputChar = getUserChoice(scanner);
        while (inputChar != gameModel.getQuitCharacter()) {
            char computerChar = generateComputerChoice();
            System.out.println(gameModel.calculateGameResult(inputChar,
                    computerChar));
            inputChar = getUserChoice(scanner);
        }

        System.out.println(gameModel.displayFinalScore());

        scanner.close();
    }

    private char getUserChoice(Scanner scanner) {
        char inputChar = ' ';

        while (gameModel.getCharacterIndex(inputChar) < 0) {
            System.out.print(gameModel.generatePrompt());
            String input = scanner.nextLine().toLowerCase();
            inputChar = input.charAt(0);
        }

        return inputChar;
    }

    private char generateComputerChoice() {
        int index = random.nextInt(gameModel.getChoicesLength() - 1);
        return gameModel.getChoiceCharacter(index);
    }

    public class GameModel {

        private final String[] CHOICES = { "Rock", "Paper", "Scissors", "Quit" };

        private int playerScore;
        private int computerScore;
        private int tieScore;

        public GameModel() {
            this.playerScore = 0;
            this.computerScore = 0;
            this.tieScore = 0;
        }

        public String getChoice(int index) {
            return CHOICES[index];
        }

        public char getChoiceCharacter(int index) {
            return CHOICES[index].toLowerCase().charAt(0);
        }

        public int getChoicesLength() {
            return CHOICES.length;
        }

        public char getQuitCharacter() {
            return getChoiceCharacter(getChoicesLength() - 1);
        }

        public int getPlayerScore() {
            return playerScore;
        }

        public int getComputerScore() {
            return computerScore;
        }

        public int getTieScore() {
            return tieScore;
        }

        public String generatePrompt() {
            StringBuilder builder = new StringBuilder();
            builder.append(CHOICES[0]);
            builder.append(", ");
            builder.append(CHOICES[1]);
            builder.append(", ");
            builder.append(CHOICES[2]);
            builder.append("; Enter ");
            builder.append(getChoiceCharacter(0));
            builder.append(", ");
            builder.append(getChoiceCharacter(1));
            builder.append(", ");
            builder.append(getChoiceCharacter(2));
            builder.append(", or ");
            builder.append(getChoiceCharacter(3));
            builder.append(" to ");
            builder.append(CHOICES[3].toLowerCase());
            builder.append(": ");

            return builder.toString();
        }

        public String calculateGameResult(char inputChar, char computerChar) {
            if (inputChar == computerChar) {
                tieScore++;
                return "We chose the same item.  Let's try again.\n";
            } else {
                int inputIndex = getCharacterIndex(inputChar);
                int computerIndex = getCharacterIndex(computerChar);
                String s = "You chose " + CHOICES[inputIndex]
                        + ", the computer chose " + CHOICES[computerIndex]
                        + ".  ";

                int testIndex = (inputIndex + 1) % (CHOICES.length - 1);
                if (testIndex == computerIndex) {
                    computerScore++;
                    return s + "The computer wins.\n";
                } else {
                    playerScore++;
                    return s + "You win.\n";
                }
            }
        }

        private int getCharacterIndex(char c) {
            for (int index = 0; index < CHOICES.length; index++) {
                if (c == getChoiceCharacter(index)) {
                    return index;
                }
            }

            return -1;
        }

        public String displayFinalScore() {
            StringBuilder builder = new StringBuilder();
            builder.append("\nThe final score: Player ");
            builder.append(playerScore);
            builder.append(", Computer ");
            builder.append(computerScore);
            builder.append(", ties ");
            builder.append(tieScore);
            builder.append(".");

            return builder.toString();
        }

    }

}