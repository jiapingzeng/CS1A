package edu.foothill;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControlsFrame extends JFrame {

    JLabel guideLabel;
    JPanel mainPanel;
    JComboBox moviesComboBox;
    JLabel widthLabel;
    JTextField widthText;
    JLabel heightLabel;
    JTextField heightText;
    JButton setSizeButton;

    public ControlsFrame(String title) {
        super(title);
        setLayout(new BorderLayout(20, 10));

        String[] movies = { "Tron", "Deadpool", "Matrix", "Avatar", "Spiderman", "Magic Mike", "Star Wars", "Justice League", "Moonrise Kingdom", "Harry Potter" };

        guideLabel = new JLabel("Choose a poster from the dropdown.");
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        moviesComboBox = new JComboBox(movies);
        widthLabel = new JLabel("Width: ");
        widthText = new JTextField("600", 7);
        heightLabel = new JLabel("Height: ");
        heightText = new JTextField("900", 7);
        setSizeButton = new JButton("Set Size");

        mainPanel.setBorder(new TitledBorder("Movie Poster"));
        setSizeButton.addActionListener(new setSizeButtonListener());

        add(guideLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(moviesComboBox);
        mainPanel.add(widthLabel);
        mainPanel.add(widthText);
        mainPanel.add(heightLabel);
        mainPanel.add(heightText);
        mainPanel.add(setSizeButton);
    }

    public void displayImage(int width, int height, String imagePath) {
        ImageDisplay display =new ImageDisplay();
        display.setImagePath(imagePath);
        JFrame imageFrame = new JFrame();
        imageFrame.setLocationRelativeTo(this);
        imageFrame.setSize(width, height);
        imageFrame.setVisible(true);
        imageFrame.add(display);
    }

    class setSizeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int width;
            int height;
            try {
                width = Integer.parseInt(widthText.getText());
                height = Integer.parseInt(heightText.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid width or height");
                width = 600;
                height = 900;
            }
            String imagePath = "posters/" + moviesComboBox.getSelectedItem().toString().toLowerCase().replace(' ', '_') + ".jpg";
            displayImage(width, height, imagePath);
        }
    }
}