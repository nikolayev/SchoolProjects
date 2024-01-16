import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

//This is the UI for the specific instance of game
//It also extends JFrame which represents a window in Java Swing
//Alexander Nikolayev 01/16/2024
public class GameScreen extends JFrame {

    //List of possible colors of buttons
    private final Color[] colorPalette = {Color.red, Color.cyan, Color.yellow, Color.green};
    private final Game game;
    private final JLabel scoreLabel;
    private final JLabel questionLabel;
    private final JPanel buttonsPanel;
    private final List<JButton> buttonList = new ArrayList<>();

    // Constructor (R.2.1)
    public GameScreen(Game game) {
        super("New Game");
        this.game = game;

        //Set window dimensions
        setMinimumSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Creates the main panel that contains all other components
        //Uses box layout to stack components vertically
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Spacer
        panel.add(Box.createVerticalGlue());

        //Label that contains the text of the current question
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(questionLabel);

        //Spacer
        panel.add(Box.createHorizontalStrut(20));

        //Separate sub-panel that contains the answer buttons
        buttonsPanel = new JPanel();
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonsPanel);

        //Spacer
        panel.add(Box.createHorizontalStrut(20));

        //Label that contains current game score
        scoreLabel = new JLabel();
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(scoreLabel);

        //Spacer
        panel.add(Box.createVerticalGlue());

        add(panel);

        //This advances to the first question then updates the UI with the question text and possible answers
        // UI setup code...
        // R.2.4 - Utilizing Swing (a Java GUI library) methods
        Question question = game.getNextQuestion();
        setQuestion(question);
        setScore();
    }

    //Button click listener for the answer buttons (R.2.3 - void method with parameters)
    public void answerButtonClicked(ActionEvent e) {
        //Determine answer index based on which button was clicked
        JButton button = (JButton) e.getSource();
        int answerIndex = buttonList.indexOf(button);

        //Check if the answer is correct
        // UI updates...
        // R.3 - Decision-making (if-else)
        // R.4 - Iteration (updating UI elements)
        CheckedAnswer result = game.checkAnswer(answerIndex);

        //Show the results
        String popUp = String.format("The answer is %s", result.isCorrect() ? "correct" : "incorrect, the correct answer was '" + result.getCorrectAnswer().getText()) + "'";
        JOptionPane.showMessageDialog(this, popUp);

        //Update the score on the screen
        setScore();

        if (game.hasMoreQuestions()) {
            //Advance to the next question if there is another question
            Question nextQuestion = game.getNextQuestion();
            setQuestion(nextQuestion);
        } else {
            //End of game when there are no more questions
            //Remove all buttons and show the final stats
            buttonsPanel.removeAll();
            int correctCount = game.getCorrectCount();
            int incorrectCount = game.getQuestionCount() - correctCount;
            String message = String.format("Game Over. Correct: %d, Incorrect: %d", correctCount, incorrectCount);
            questionLabel.setText(message);
        }
    }

    //Update the UI for a specific question
    public void setQuestion(Question question) {
        //Set the question text
        this.questionLabel.setText(question.getText());

        List<Answer> answers = question.getAnswers();

        //Clear old buttons
        buttonsPanel.removeAll();
        buttonList.clear();

        //Use grid layout with rows and columns based on the number of answers
        int columns = answers.size() == 3 ? 3 : 2;
        int rows = answers.size() / columns;
        buttonsPanel.setLayout(new GridLayout(rows, columns));

        //Add new buttons for possible answers
        //Changes based on number of answers
        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);
            JButton button = new JButton(answer.getText());
            button.addActionListener(this::answerButtonClicked);
            button.setFont(new Font("Serif", Font.PLAIN, 18));

            //Get the background color from predefined color palette based on the button index
            //When all the colors are used up, then wrap back to the beginning.
            button.setBackground(colorPalette[i % colorPalette.length]);
            buttonsPanel.add(button);
            buttonList.add(button);
        }
    }

    //Update the UI for the current game score
    private void setScore() {
        int score = game.getScore();
        String text = String.format("Score: %d", score);
        scoreLabel.setText(text);
    }

    //Mutator, makes the window visible
    public void display() {
        setVisible(true);
    }
}
