import java.awt.*;
import java.util.Random;

public class Block {
    private BlockShape shape; // THIS is an Association with TetrisShape
    private BlockColor color; // THIS is an Association with TetrisColor

    public Block() {
        shape = new BlockShape();
        color = new BlockColor();
    }

    // Draw the block
    public void drawBlocks(Graphics g) {
        g.setColor(color.getColor());
        g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    // Dumb required inner class for shape properties
    public class BlockShape {
        private int x, y, width, height;

        public BlockShape() {
            // Initialize position
            x = 0;
            y = 0;
            width = 30;
            height = 30;
        }

        // Getters and setters (this gets us the encapsulation pts)
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }

        public int getY() { return y; }
        public void setY(int y) { this.y = y; }

        public int getWidth() { return width; }
        public int getHeight() { return height; }
    }

    // Inner class for color properties
    public class BlockColor {
        private Color color;

        public BlockColor() {
            // Randomize color for variety
            Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE};
            Random rand = new Random();
            color = colors[rand.nextInt(colors.length)];
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}
