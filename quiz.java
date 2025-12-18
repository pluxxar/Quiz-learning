import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class quiz {

    static int askQuestion(Scanner sc, String question, String[] options, char correct) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(question);
        System.out.println("=".repeat(50));

        for (String opt : options) {
            System.out.println("  " + opt);
        }

        System.out.print("\nYour Answer (a/b/c): ");
        String input = sc.next().toLowerCase();
        
        if (input.length() == 0) {
            System.out.println("❌ No answer provided.");
            return 0;
        }
        
        char userAns = input.charAt(0);

        if (userAns != 'a' && userAns != 'b' && userAns != 'c') {
            System.out.println("❌ Invalid choice. Please enter a, b, or c.");
            return 0;
        }

        if (userAns == correct) {
            System.out.println("✅ Correct!");
            return 1;
        } else {
            System.out.println("❌ Wrong! The correct answer was: " + correct);
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           WELCOME TO THE QUIZ!");
        System.out.println("=".repeat(50) + "\n");

        Scanner sc = new Scanner(System.in);
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String[]> optionsList = new ArrayList<>();
        ArrayList<Character> answers = new ArrayList<>();

        try {
            File file = new File("questions.txt");
            
            if (!file.exists()) {
                System.out.println("❌ Error: questions.txt file not found!");
                System.out.println("Please make sure questions.txt is in the same directory.");
                return;
            }
            
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                
                if (line.isEmpty()) continue; // Skip empty lines
                
                String[] parts = line.split("\\|");
                
                if (parts.length != 3) {
                    System.out.println("⚠️  Warning: Skipping malformed line: " + line);
                    continue;
                }

                questions.add(parts[0]);
                optionsList.add(parts[1].split(","));
                answers.add(parts[2].charAt(0));
            }

            fileReader.close();
            
            if (questions.isEmpty()) {
                System.out.println("❌ Error: No valid questions found in questions.txt");
                return;
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
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

        System.out.println("\n" + "=".repeat(50));
        System.out.println("           QUIZ COMPLETED!");
        System.out.println("=".repeat(50));
        System.out.println("Final Score: " + score + "/" + questions.size());
        
        double percentage = (score * 100.0) / questions.size();
        System.out.println("Percentage: " + String.format("%.1f", percentage) + "%");
        
        if (percentage == 100) {
            System.out.println("🏆 Perfect score! Outstanding!");
        } else if (percentage >= 80) {
            System.out.println("🎯 Excellent work!");
        } else if (percentage >= 60) {
            System.out.println("👍 Good effort!");
        } else {
            System.out.println("📚 Keep practicing!");
        }
        
        System.out.println("=".repeat(50) + "\n");
        
        sc.close();
    }
}
