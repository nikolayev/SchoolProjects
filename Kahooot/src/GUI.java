import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame {

        public GUI() {
                super("KAHOOT");
                int width = 800;
                int height = 800;
                setMinimumSize(new Dimension(width, height));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                // center the JLabel
                JLabel lblText = new JLabel("KAHOOOT", SwingConstants.CENTER);

                // add JLabel to JFrame
                getContentPane().add(lblText);
        }

        public void display() {
                pack();
                setVisible(true);
        }
}

