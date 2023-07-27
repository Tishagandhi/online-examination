import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class OnlineExaminationSystem {
    private Map<String, User> users;
    private Question[] questions;

    public OnlineExaminationSystem() {
        users = new HashMap<>();
        // Adding a sample user for demonstration purposes
        users.put("user123", new User("user123", "password123"));

        // Creating sample questions for the exam
        questions = new Question[3];
        questions[0] = new Question("What is 2 + 2?", new String[]{"1", "2", "3", "4"}, 3);
        questions[1] = new Question("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Madrid"}, 1);
        questions[2] = new Question("Which planet is known as the 'Red Planet'?", new String[]{"Mars", "Venus", "Jupiter", "Saturn"}, 0);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Examination System!");

        while (true) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            User user = users.get(username);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("Authentication successful. Welcome, " + username + "!");
                takeExam(scanner);
                break;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        scanner.close();
    }

    private void takeExam(Scanner scanner) {
        int score = 0;

        System.out.println("\nSample Exam Questions:");
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            System.out.println((i + 1) + ". " + question.getQuestionText());

            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println("   " + (char) ('A' + j) + ") " + options[j]);
            }

            System.out.print("Your answer (A/B/C/D): ");
            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals(String.valueOf((char) ('A' + question.getCorrectOption())))) {
                score++;
            }
        }

        System.out.println("\nExam completed! Your score: " + score + " out of " + questions.length);
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineExaminationSystem onlineExam = new OnlineExaminationSystem();
        onlineExam.start();
    }
}

