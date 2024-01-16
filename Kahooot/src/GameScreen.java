import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame {
    private final Color[] colorPalette = {Color.red, Color.cyan, Color.yellow, Color.green, Color.orange, Color.pink, Color.blue, Color.white, Color.magenta};
    private final Game game;
    private final JLabel scoreLabel;
    private final JLabel questionLabel;
    private final JPanel buttonsPanel;
    private final List<JButton> buttonList = new ArrayList<>();

    public GameScreen(Game game) {
        super("New Game");
        this.game = game;
        int width = 800;
        int height = 800;
        setMinimumSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(questionLabel);

        panel.add(Box.createHorizontalStrut(20));

        buttonsPanel = new JPanel();
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonsPanel);

        panel.add(Box.createHorizontalStrut(20));

        scoreLabel = new JLabel();
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(scoreLabel);

        panel.add(Box.createVerticalGlue());

        add(panel);

        Question question = game.getNextQuestion();
        setQuestion(question);
        setScore();
    }

    public void answerButtonClicked(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int answerIndex = buttonList.indexOf(button);

        CheckedAnswer result = game.checkAnswer(answerIndex);
        String popUp = String.format("The answer is %s", result.isCorrect() ? "correct" : "incorrect, the correct answer was '" + result.getCorrectAnswer().getText()) + "'";
        JOptionPane.showMessageDialog(this, popUp);
        setScore();
        if (game.hasMoreQuestions()) {
            Question nextQuestion = game.getNextQuestion();
            setQuestion(nextQuestion);
        } else {
            buttonsPanel.removeAll();
            int correctCount = game.getCorrectCount();
            int incorrectCount = game.getQuestionCount() - correctCount;
            String message = String.format("Game Over. Correct: %d, Incorrect: %d", correctCount, incorrectCount);
            questionLabel.setText(message);
        }
    }

    public void setQuestion(Question question) {
        this.questionLabel.setText(question.getText());
        List<Answer> answers = question.getAnswers();
        buttonsPanel.removeAll();
        buttonList.clear();

        int columns = answers.size() == 3 ? 3 : 2;
        int rows = answers.size() / columns;
        buttonsPanel.setLayout(new GridLayout(rows, columns));

        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);
            JButton button = new JButton(answer.getText());
            button.addActionListener(this::answerButtonClicked);
            button.setFont(new Font("Serif", Font.PLAIN, 18));
            button.setBackground(colorPalette[i]);
            buttonsPanel.add(button);
            buttonList.add(button);
        }
    }

    private void setScore() {
        int score = game.getScore();
        String text = String.format("Score: %d", score);
        scoreLabel.setText(text);
    }
}
