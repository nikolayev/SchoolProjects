import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.display();

        QuestionDatabase questionDatabase = new QuestionDatabase();
        Game game = new Game(questionDatabase.getQuestions());
    }



}