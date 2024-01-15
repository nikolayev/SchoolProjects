import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        GUI gui = new GUI();
//        gui.display();

        QuestionDatabase questionDatabase = new QuestionDatabase();
        ArrayList<Question> questions = questionDatabase.getQuestions();
        Game game = new Game(questions);

        Question currentQuestion;

        currentQuestion = game.getNextQuestion();
        boolean checkedAnswer = game.checkAnswer(0);
        int score = game.getScore();

        currentQuestion = game.getNextQuestion();
        checkedAnswer = game.checkAnswer(2);
        score = game.getScore();

        currentQuestion = game.getNextQuestion();
        checkedAnswer = game.checkAnswer(2);
        score = game.getScore();

        currentQuestion = game.getNextQuestion();
        checkedAnswer = game.checkAnswer(3);
        score = game.getScore();


    }
}
