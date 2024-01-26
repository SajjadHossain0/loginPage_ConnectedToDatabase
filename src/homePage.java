import javax.swing.*;
import java.awt.*;

public class homePage {
    private  JFrame frame;
    public homePage() {
        frame = new JFrame();
        frame.setSize(350,400);
        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel label = new JLabel("Welcome to home :) <3");
        label.setBackground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,350,400);
        panel.setBackground(Color.cyan);
        panel.add(label);
        frame.add(panel);

        frame.setVisible(true);

        

    }
}
