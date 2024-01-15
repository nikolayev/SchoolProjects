import java.util.List;
import javax.swing.*;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainScreen extends JFrame {

        private final List<Question> questions;
        private Game game;

        public MainScreen(List<Question> questions) {
                super("KAHOOT");
                this.questions = questions;

                int width = 800;
                int height = 800;
                setMinimumSize(new Dimension(width, height));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel();
                JLabel lblText = new JLabel("KAHOOOT", SwingConstants.CENTER);
                panel.add(lblText);

                JButton startButton = new JButton("Start New Game");
                startButton.addActionListener(this::startButtonClicked);
                panel.add(startButton);

                this.add(panel);
        }

        public void display() {
                //pack();
                setVisible(true);
        }

        public void startButtonClicked(ActionEvent e)
        {
                //JOptionPane.showMessageDialog(this, "Yay!");
                this.game = new Game(questions);
                GameScreen gameScreen = new GameScreen(game);
                gameScreen.setVisible(true);
        }
}

