import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JavaGUI extends JFrame {
    private TetrisState state; // THIS is an Association with TetrisState
    private TetrisBlocks blocks; // THIS is an Association with TetrisBlocks
    private TetrisClock clock; // THIS is an Association with TetrisClock
    private TetrisScoreCount scoreCount; // THIS is an Association with TetrisScoreCount

    public JavaGUI() {
        state = new TetrisState();
        blocks = new TetrisBlocks();
        scoreCount = new TetrisScoreCount();
        clock = new TetrisClock(this, blocks, state, scoreCount); // This Passes references  also an Association

        setTitle("Tetris Game");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating panels and adding to the GUI
        GamePanel gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        // Side panel for score and timer
        SidePanel sidePanel = new SidePanel();
        add(sidePanel, BorderLayout.EAST);

        // Start game clock
        clock.start();

        // Key listener for block movement
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (state.isPlaying()) {
                    blocks.moveBlock(e.getKeyCode());
                    repaint();
                }
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    // Internal class for game rendering
    private class GamePanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (state.isPlaying()) {
                blocks.drawBlocks(g); // This Draws current blocks
            } else {
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Game Over", 100, 400);
            }
        }
    }

    // This is our amazing tetris internal class for side panel to display score and timer
    private class SidePanel extends JPanel {
        public SidePanel() {
            setPreferredSize(new Dimension(150, 800));
            setBackground(Color.LIGHT_GRAY);
            setLayout(new GridLayout(2, 1));

            // Score display
            JPanel scorePanel = new JPanel();
            scorePanel.setBackground(Color.LIGHT_GRAY);
            JLabel scoreLabel = new JLabel("Score: ");
            JLabel scoreValue = new JLabel("0");
            scoreCount.setScoreLabel(scoreValue);
            scorePanel.add(scoreLabel);
            scorePanel.add(scoreValue);

            // Timer display
            JPanel timerPanel = new JPanel();
            timerPanel.setBackground(Color.LIGHT_GRAY);
            JLabel timerLabel = new JLabel("Timer: ");
            JLabel timerValue = new JLabel("0");
            clock.setTimerLabel(timerValue);
            timerPanel.add(timerLabel);
            timerPanel.add(timerValue);

            add(scorePanel);
            add(timerPanel);
        }
    }

    // This is a generated method to repaint the game panel when the block sticks (or should stick
    public void refresh() {
        repaint();
    }

    public static void main(String[] args) {
        new JavaGUI();
    }
}
