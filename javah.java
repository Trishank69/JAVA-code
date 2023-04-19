import javax.swing.JOptionPane;

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        while (userAnswer != computerNumber) {
            String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and 100", "Guessing Game",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                userAnswer = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input, please enter a number.");
                continue;
            }
            JOptionPane.showMessageDialog(null, determineGuess(userAnswer, computerNumber, count));
            count++;
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        } else {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
    }
}