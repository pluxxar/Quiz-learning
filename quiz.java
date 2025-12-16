import java.util.Scanner;

public class quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz!");

        System.out.println("Q1: Java is a ?");
        System.out.println("a) OS");
        System.out.println("b) Programming Language");
        System.out.println("c) Browser");
        char ans1 = sc.next().charAt(0);

        if (ans1 == 'b') {
            score++;
        }

        System.out.println("Your score is: " + score);
        sc.close();
    }
}
