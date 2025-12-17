import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class quiz {

    static int askQuestion(Scanner sc, String question, String[] options, char correct) {

        System.out.println("\n" + question);

        for (String opt : options) {
            System.out.println(opt);
        }

        System.out.print("Your Answer (a/b/c): ");
        char userAns = Character.toLowerCase(sc.next().charAt(0));

        if (userAns != 'a' && userAns != 'b' && userAns != 'c') {
            System.out.println("Invalid choice.");
            return 0;
        }

        return userAns == correct ? 1 : 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String[]> optionsList = new ArrayList<>();
        ArrayList<Character> answers = new ArrayList<>();

        try {
            File file = new File("questions.txt");
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split("\\|");

                questions.add(parts[0]);
                optionsList.add(parts[1].split(","));
                answers.add(parts[2].charAt(0));
            }

            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return;
        }

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            score += askQuestion(
                    sc,
                    "Q" + (i + 1) + ": " + questions.get(i),
                    optionsList.get(i),
                    answers.get(i)
            );
        }

        System.out.println("\nFinal Score: " + score + "/" + questions.size());
        sc.close();
    }
}
