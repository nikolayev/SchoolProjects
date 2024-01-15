import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class GameScreen extends JFrame {
    private final Game game;
    private final JLabel scoreLabel;
    private final JLabel questionLabel;
    private final JPanel buttonsPanel;
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;

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
        button1 = new JButton();
        button1.addActionListener(this::answerButtonClicked);
        buttonsPanel.add(button1);
        button2 = new JButton();
        button2.addActionListener(this::answerButtonClicked);
        buttonsPanel.add(button2);
        button3 = new JButton();
        button3.addActionListener(this::answerButtonClicked);
        buttonsPanel.add(button3);
        button4 = new JButton();
        button4.addActionListener(this::answerButtonClicked);
        buttonsPanel.add(button4);
        panel.add(buttonsPanel);

        scoreLabel = new JLabel();
        panel.add(scoreLabel);

        add(panel);

        Question question = game.getNextQuestion();
        setQuestion(question);
        setScore();
    }

    public void answerButtonClicked(ActionEvent e)
    {
        int answerIndex = -1;
        if (e.getSource() == button1) {
            answerIndex = 0;
        } else if (e.getSource() == button2) {
            answerIndex = 1;
        } else if (e.getSource() == button3) {
            answerIndex = 2;
        } else if (e.getSource() == button4) {
            answerIndex = 3;
        }
        boolean isCorrect = game.checkAnswer(answerIndex);
        setScore();
        JOptionPane.showMessageDialog(this, String.format("The answer %s!", isCorrect ? "correct" : "incorrect"));
        if(game.hasMoreQuestions()){
            Question nextQuestion = game.getNextQuestion();
            setQuestion(nextQuestion);
        } else {
            buttonsPanel.removeAll();
            questionLabel.setText("Game Over");
        }

    }

    public void setQuestion(Question question) {
        this.questionLabel.setText(question.getText());
        List<Answer> answers = question.getAnswers();
        button1.setText(answers.get(0).getText());
        button2.setText(answers.get(1).getText());
        button3.setText(answers.get(2).getText());
        button4.setText(answers.get(3).getText());
    }

    private void setScore() {
        int score = game.getScore();
        scoreLabel.setText(Integer.toString(score));
    }
}
