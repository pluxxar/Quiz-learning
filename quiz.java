import java.util.Scanner;

public class quiz {
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

                System.out.println("\nQ" + (i + 1) + ": " + questions[i]);

                for (int j = 0; j < options[i].length; j++) {
                    System.out.println(options[i][j]);
                }

                System.out.print("Your Answer (a/b/c): ");
                char userAns = Character.toLowerCase(sc.next().charAt(0));

                if (userAns != 'a' && userAns != 'b' && userAns != 'c') {
                    System.out.println("Invalid choice. Skipping question.");
                    continue;
                }

                if (userAns == answers[i]) {
                    score++;
                }
            }

            int total = questions.length;
            int percentage = (score * 100) / total;

            System.out.println("\n===== RESULT =====");
            System.out.println("Score: " + score + "/" + total);
            System.out.println("Percentage: " + percentage + "%");

            if (percentage >= 40) {
                System.out.println("Status: PASS ✅");
            } else {
                System.out.println("Status: FAIL ❌");
            }

            System.out.print("\nDo you want to retry the quiz? (y/n): ");
            retry = Character.toLowerCase(sc.next().charAt(0));

        } while (retry == 'y');

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}
