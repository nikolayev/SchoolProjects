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

        while(game.hasMoreQuestions()){
            currentQuestion = game.getNextQuestion();
            boolean checkedAnswer = game.checkAnswer(1);
            int score = game.getScore();
        }
        int finalScore = game.getScore();
        System.out.println(finalScore);
    }
}
