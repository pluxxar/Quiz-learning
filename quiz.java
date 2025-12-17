import java.util.Scanner;

public class quiz {

    // Method to ask a single question
    static int askQuestion(
            Scanner sc,
            String question,
            String[] options,
            char correctAnswer
    ) {
        System.out.println("\n" + question);

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }

        System.out.print("Your Answer (a/b/c): ");
        char userAns = Character.toLowerCase(sc.next().charAt(0));

        if (userAns != 'a' && userAns != 'b' && userAns != 'c') {
            System.out.println("Invalid choice.");
            return 0;
        }

        if (userAns == correctAnswer) {
            return 1; // correct
        }

        return 0; // wrong
    }

    // Method to show result
    static void showResult(int score, int total) {
        int percentage = (score * 100) / total;

        System.out.println("\n===== RESULT =====");
        System.out.println("Score: " + score + "/" + total);
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 40) {
            System.out.println("Status: PASS ✅");
        } else {
            System.out.println("Status: FAIL ❌");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char retry;

        String[] questions = {
            "Java is a ?",
            "Which one is a loop?"
        };

        String[][] options = {
            {"A) OS", "B) Programming Language", "C) Browser"},
            {"A) If", "B) For", "C) Break"}
        };

        char[] answers = {'b', 'b'};

        do {
            int score = 0;

            System.out.println("\nWELCOME TO THE QUIZ!");

            for (int i = 0; i < questions.length; i++) {
                score += askQuestion(
                        sc,
                        "Q" + (i + 1) + ": " + questions[i],
                        options[i],
                        answers[i]
                );
            }

            showResult(score, questions.length);

            System.out.print("\nDo you want to retry the quiz? (y/n): ");
            retry = Character.toLowerCase(sc.next().charAt(0));

        } while (retry == 'y');

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}
