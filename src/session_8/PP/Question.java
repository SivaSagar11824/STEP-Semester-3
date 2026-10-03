import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQQuestion extends Question {

    MCQQuestion(String questionText, String correctAnswer,
                String studentAnswer, double points) {

        super(questionText, correctAnswer,
              studentAnswer, points);
    }

    double calculateScore() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion extends Question {

    TFQuestion(String questionText, String correctAnswer,
               String studentAnswer, double points) {

        super(questionText, correctAnswer,
              studentAnswer, points);
    }

    double calculateScore() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends Question {

    EssayQuestion(String questionText, String correctAnswer,
                  String studentAnswer, double points) {

        super(questionText, correctAnswer,
              studentAnswer, points);
    }

    double calculateScore() {

        String[] keywords = correctAnswer.split(",");

        int count = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            /*
             * Extract:
             * Type
             * Question
             * Correct Answer
             * Student Answer
             * Points
             */

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];

            String correctAnswer = parts[3];

            String studentAnswer = parts[5];

            String remaining = parts[6].trim();

            double points = Double.parseDouble(remaining);

            Question question;

            if (type.equals("MCQ")) {

                question = new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            } else if (type.equals("TF")) {

                question = new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            } else {

                question = new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );
            }

            double score = question.calculateScore();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    score
            );

            totalScore += score;
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore
        );

        sc.close();
    }
}