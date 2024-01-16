import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends JFrame {
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

        questionLabel = new JLabel();
        panel.add(questionLabel);

        buttonsPanel = new JPanel();
        panel.add(buttonsPanel);

        scoreLabel = new JLabel();
        panel.add(scoreLabel);

        add(panel);

        Question question = game.getNextQuestion();
        setQuestion(question);
        setScore();
    }

    public void answerButtonClicked(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int answerIndex = buttonList.indexOf(button);

        CheckedAnswer result = game.checkAnswer(answerIndex);
        JOptionPane.showMessageDialog(this, String.format("The answer %s!", result.isCorrect() ? "correct" : "incorrect"));
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
        for (Answer answer : answers) {
            JButton button = new JButton(answer.getText());
            button.addActionListener(this::answerButtonClicked);
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
