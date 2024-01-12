import javax.swing.*;
import java.awt.*;

public class Main {
    QuestionDatabase questionDatabase = new QuestionDatabase();
    Game game = new Game(questionDatabase.getQuestions());
}