import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuestionDatabase database = new QuestionDatabase();
        List<Question> questions = database.getQuestions();

        SwingUtilities.invokeLater(() -> {
            MainScreen gui = new MainScreen(questions);
            gui.display();
        });
    }
}
