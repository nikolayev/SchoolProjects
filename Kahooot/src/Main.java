import javax.swing.*;
import java.util.List;
//Alexander Nikolayev 01/16/2024
// Program entry point (R.1) - Utilizes the String[] data type to store arguments
public class Main {
    //Program entry point

    public static void main(String[] args) {

        // Creating an instance of QuestionDatabase
        // (R.2.1) - Student-made object initialization
        QuestionDatabase database = new QuestionDatabase();

        // Fetching questions from the database
        // List<Question> is a data type used to store a list of Question objects
        List<Question> questions = database.getQuestions();

        // SwingUtilities.invokeLater ensures that the UI code runs on the UI thread (R.4 - Iteration in UI thread management)
        SwingUtilities.invokeLater(() -> {

            // Creating a MainScreen object with questions and displaying it
            // (R.2.1) - Using the student-made object
            MainScreen gui = new MainScreen(questions);
            gui.display();
        });
    }
}
