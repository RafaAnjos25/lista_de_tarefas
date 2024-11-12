import javax.swing.*;
import java.awt.*;

class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false);  // Makes sure the panel is transparent so we can see the rounded corners
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arcWidth = cornerRadius * 2;
        int arcHeight = cornerRadius * 2;

        // Draws the rounded background area
        graphics.setColor(getBackground());  // Background color of the panel
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcWidth, arcHeight);

        // Draws the rounded border
        graphics.setColor(Color.BLACK);  // Border color
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcWidth, arcHeight);
    }
}
