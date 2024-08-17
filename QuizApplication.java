import java.util.*;

class QuizQuestion {
    String question;
    String[] options;
    int correctAnswerIndex;

    QuizQuestion(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    void display() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

class Quiz {
    List<QuizQuestion> questions = new ArrayList<>();
    int score = 0;

    void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        for (QuizQuestion question : questions) {
            question.display();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    System.exit(0);
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, 15000); // 15 seconds timer
            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();
            timer.cancel();
            if (question.isCorrect(answer - 1)) score++;
            System.out.println();
        }
        displayResult();
        scanner.close();
    }

    void displayResult() {
        System.out.println("Quiz Over! Your final score is: " + score + " out of " + questions.size());
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new QuizQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Lisbon"}, 2));
        quiz.addQuestion(new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1));
        quiz.addQuestion(new QuizQuestion("Who wrote 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald"}, 0));
        quiz.addQuestion(new QuizQuestion("What is the largest ocean on Earth?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3));
        quiz.start();
    }
}
