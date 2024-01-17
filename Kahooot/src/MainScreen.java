import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//This is the UI for the title screen
//Can begin the game from here
//This class extends JFrame which represents a window in Java Swing
//Alexander Nikolayev 01/16/2024
public class MainScreen extends JFrame {

    private final List<Question> questions;

    //Constructor (R.2.1)
    public MainScreen(List<Question> questions) {
        super("KAHOOT");
        this.questions = questions;

        //Set window dimensions
        setMinimumSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Main panel that contains all other components
        //Use box layout so that components are stacked vertically
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Spacer
        panel.add(Box.createVerticalGlue());

        //Application Title
        JLabel gameTitle = new JLabel("KAHOOOT", SwingConstants.CENTER);
        gameTitle.setFont(new Font("Serif", Font.PLAIN, 58));
        gameTitle.setForeground(new Color(0x46, 0x17, 0x8f));
        gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(gameTitle);

        //Spacer
        panel.add(Box.createHorizontalStrut(10));

        //Start game button
        JButton startButton = new JButton("Start New Game");
        startButton.addActionListener(this::startButtonClicked);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(startButton);

        //Spacer
        panel.add(Box.createVerticalGlue());

        this.add(panel);
    }

    //Mutator, makes the window visible (R.2.3 - void method)
    //Pre-condition: Can be called at any time
    //Post-condition: Makes the screen visible
    public void display() {
        setVisible(true);
    }

    //Button click listener that creates the game object and creates the game window
    //Pre-condition: The window is visible and the start button is clicked
    //Post-condition: Creates new game and the new game window is visible
    public void startButtonClicked(ActionEvent e) {
        Game game = new Game(questions);
        GameScreen gameScreen = new GameScreen(game);
        gameScreen.display();
    }
}