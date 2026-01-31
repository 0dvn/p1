import java.awt.*;
import javax.swing.*;

public class ConcentricCircles extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Concentric Circles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new ConcentricCircles());
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int numCircles = 10; // Number of circles
        int gap = 20;        // Gap between circles
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (int i = 0; i < numCircles; i++) {
            int radius = i * gap;
            g.setColor(new Color(0, 100 + i * 15, 200 - i * 10)); // Gradual color change
            g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        }
    }
}