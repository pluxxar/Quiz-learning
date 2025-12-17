import java.util.Scanner;

public class quiz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        String[] questions = {
            "Java is a ?",
            "Which one is a loop?"
        };

        String[][] options = {
            {"A) OS", "B) Programming Language", "C) Browser"},
            {"A) If", "B) For", "C) Break"}
        };

        char[] answers = {'b', 'b'};

        System.out.println("WELCOME TO THE QUIZ!");

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

        System.out.println("\nQuiz Finished!");
        System.out.println("Your Score: " + score + "/" + questions.length);

        sc.close();
    }
}
