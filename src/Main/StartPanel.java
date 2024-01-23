package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
    private ImageIcon bg;

    public StartPanel() {
        try {
            // Load the background image
            bg = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/background/bg.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (bg != null) {
            Image image = bg.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Create the start screen
        JFrame start = new JFrame("Pixel Game");
        start.setSize(17*48, 12*48);
        start.setResizable(false);
        start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a JPanel for the background
        StartPanel bgPanel = new StartPanel();
        bgPanel.setLayout(null);

        // Create a JButton for starting the game
        JButton startGame = new JButton("");
        startGame.setSize(193,52);
        startGame.setLocation(6*48, 315);
        startGame.setBorderPainted(false);
        startGame.setFocusPainted(false);
        startGame.setContentAreaFilled(false);
        startGame.addActionListener(e -> {
            // Handle button click (start the game or perform other actions)
            Main.main();
            start.dispose();
        });
        start.setLocationRelativeTo(null);
        // Add components to the background panel
        bgPanel.add(startGame);

        // Set layout to null to freely position components
        bgPanel.setLayout(null);

        // Add the background panel to the frame
        start.setContentPane(bgPanel);

        // Make the frame visible after adding components
        start.setVisible(true);
    }
}
