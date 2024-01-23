package Main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main() {

        JFrame scr = new JFrame();
        scr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scr.setResizable(false);
        scr.setSize(768, 576);
        scr.setTitle("Treasure Hunting Game");
//        try {
//            // Đọc hình ảnh từ tệp trong thư mục /background
//            BufferedImage backgroundImage = ImageIO.read(Main.class.getResourceAsStream("/background/start.png"));
//
//            // Tạo một JLabel để chứa hình ảnh và đặt nó làm nền cho JFrame
//            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
//            scr.setContentPane(backgroundLabel);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        GamePanel gamePanel = new GamePanel();
        scr.add(gamePanel);
        JButton startButton = new JButton();
//        startButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("click");
//                scr.remove(startButton);
//
//                gamePanel.startgame();
//                scr.setSize(768, 576);
//                scr.setLocationRelativeTo(null);
//            }
//        });
        
        startButton.setPreferredSize(new Dimension(300, 120));
        startButton.setLocation(456, 444);

        // Thêm startButton trước khi gọi pack() và setVisible(true)
//        scr.add(startButton);

        scr.pack();
        scr.setLocationRelativeTo(null);
        scr.setVisible(true);

        scr.add(gamePanel);
        gamePanel.setup();
        gamePanel.startgame();
    }
}
