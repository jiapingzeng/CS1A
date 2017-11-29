package edu.foothill;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsFrame extends JFrame {

    JComboBox<String> movie = new JComboBox<>();
    JLabel widthLabel = new JLabel("Width: ");
    JTextField widthText = new JTextField(10);
    JLabel heightLabel = new JLabel("Height: ");
    JTextField heightText = new JTextField(10);
    JButton setSizeButton = new JButton("Set Size");

    public ControlsFrame(String title) {
        super(title);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

        setSizeButton.addActionListener(new setSizeListener());

        add(movie);
        add(widthLabel);
        add(widthText);
        add(heightLabel);
        add(heightText);
        add(setSizeButton);
    }

    public void displayImage(int width, int height) {
        ImageDisplay display = new ImageDisplay();
        display.setImagePath("4859886671_cef0598bf3_b.jpg");
        JFrame imageFrame = new JFrame();
        imageFrame.setLocationRelativeTo(this);
        imageFrame.setSize(width, height);
        imageFrame.setVisible(true);
        imageFrame.add(display);
    }

    class setSizeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int width;
            int height;
            try {
                width = Integer.parseInt(widthText.getText());
                height = Integer.parseInt(heightText.getText());
            } catch (NumberFormatException ex) {
                width = 600;
                height = 900;
            }
            displayImage(width, height);
        }
    }
}