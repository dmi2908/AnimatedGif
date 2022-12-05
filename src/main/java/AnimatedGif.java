import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AnimatedGif extends JComponent implements ActionListener {

    private final Timer timer;
    public int x = 0;
    public int y = -20;
    private BufferedImage image;

    public AnimatedGif(int delay) {
        loadImage();
        timer = new Timer(delay, this);
    }

    public void start() {
        timer.start();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("./res/screen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        x++;
        y++;
        if (x >= 470 && y >= 450) {
            x = 0;
            y = -20;
        }
        g2d.drawImage(image, x, y, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("сАмОлЁт");
            final AnimatedGif movingPlane = new AnimatedGif(20);
            frame.add(movingPlane);
            movingPlane.start();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(480, 500);
            frame.getContentPane().setBackground(Color.WHITE);
            frame.setVisible(true);
        });
    }
}
