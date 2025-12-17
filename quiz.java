import java.util.Scanner;

public class quiz{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int score = 0;

    String[] questions = {  

        "Java Is A ?",
        "Which  one is a loop?"
    };

    String[][] options =  {
        {"A) OS","B) Programming Language", "C) Browser"},
        {"A) If", "B) For","C) Break" }
    };
    char[] answers = {'b', 'b'};
    System.out.println("WELCOME To THe Quiz !");

    for ( int i = 0; i < questions.length; i++) {
        System.out.println("\nQ" + (i + 1) + ": " + questions[i]);

        for (int j = 0; j   < options[i].length; j++) {
            System.out.println(options[i][j]);
        }

        System.out.println("Your Answer : ");
        char userAns = sc.next().charAt(0);

        if (userAns == answers[i]) {
            score++;
            
        }

    }

    System.out.println("\nQuiz Finished!");
    System.out.println("Your score: is: " + score + "/" + questions.length);

    sc.close();

}

}
    