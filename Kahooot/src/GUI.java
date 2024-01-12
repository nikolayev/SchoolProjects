import javax.swing.*;
import java.awt.*;
public class GUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("KAHOOOT");

        // set frame site
        int width = 800;
        int height = 800;
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // center the JLabel
        JLabel lblText = new JLabel("KAHOOOT", SwingConstants.CENTER);

        // add JLabel to JFrame
        frame.getContentPane().add(lblText);

        // display it
        frame.pack();
        frame.setVisible(true);
    }
}
