import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

    private final List<Question> questions;

    public MainScreen(List<Question> questions) {
        super("KAHOOT");
        this.questions = questions;

        setMinimumSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());

        JLabel gameTitle = new JLabel("KAHOOOT", SwingConstants.CENTER);
        gameTitle.setFont(new Font("Serif", Font.PLAIN, 58));
        gameTitle.setForeground(new Color(0x46, 0x17, 0x8f));
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(gameTitle);

        panel.add(Box.createHorizontalStrut(10));

        JButton startButton = new JButton("Start New Game");
        startButton.addActionListener(this::startButtonClicked);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(startButton);

        panel.add(Box.createVerticalGlue());

        this.add(panel);
    }

    public void display() {
        setVisible(true);
    }

    public void startButtonClicked(ActionEvent e) {
        Game game = new Game(questions);
        GameScreen gameScreen = new GameScreen(game);
        gameScreen.setVisible(true);
    }
}