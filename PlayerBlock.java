import java.util.Random;
import java.awt.*;
import java.util.Random;
import java.awt.event.KeyEvent;

//Inheritance
public class PlayerBlock extends Block{
    private BlockShape shape; // THIS is an Association with TetrisShape
    private BlockColor color; // THIS is an Association with TetrisColor
    private int panelWidth = 400;
    private int panelHeight = 800;
    private int blockSize = 30;

    public PlayerBlock() {
        shape = new BlockShape();
        color = new BlockColor();
    }

    @Override
    public void drawBlocks(Graphics g) {
        g.setColor(color.getColor());
        g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    // Move block based on keyCode
    public void moveBlock(int keyCode) {
        switch (keyCode) {
            //Move Left
            case KeyEvent.VK_LEFT:
                if (shape.getX() > 0) {
                    shape.setX(shape.getX() - blockSize);
                }
                break;

            //Move Right
            case KeyEvent.VK_RIGHT:
                //contains block withing white space so that it doesn't go past timer
                if(shape.getX() == 240){
                    break;
                }
                if (shape.getX() < panelWidth - blockSize) {
                    shape.setX(shape.getX() + blockSize);
                    System.out.println(shape.getX() + " " + shape.getY());
                }
                break;

            //Move Down
            case KeyEvent.VK_DOWN:
                //contains block in window
                if(shape.getY() == 720){
                    break;
                }
                if (shape.getY() < panelHeight - blockSize) {
                    shape.setY(shape.getY() + blockSize);
                }
                break;

            //Move Up
            case KeyEvent.VK_UP:
                if(shape.getY() > 0){
                    shape.setY(shape.getY() - blockSize);
                }
            default:
                break;
        }
    }
}
