import javax.swing.*;
import java.util.List;

public class Main {
    //Program entry point
    public static void main(String[] args) {
        QuestionDatabase database = new QuestionDatabase();
        List<Question> questions = database.getQuestions();

        //Required code to run a Java Swing application, makes sure that the UI code runs on a special UI thread.
        SwingUtilities.invokeLater(() -> {
            MainScreen gui = new MainScreen(questions);
            gui.display();
        });
    }
}
