import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class TetrisClock {
    private Timer timer;
    private JavaGUI gui; // THIS is an Association with JavaGUI
    private TetrisBlocks blocks; // THIS is an Association with TetrisBlocks
    private TetrisState state; // THIS is an Association with TetrisState
    private TetrisScoreCount scoreCount; // THIS is an Association with TetrisScoreCount
    private JLabel timerLabel; // This is supposed to display our timer
    private int elapsedSeconds;

    public TetrisClock(JavaGUI gui, TetrisBlocks blocks, TetrisState state, TetrisScoreCount scoreCount) {
        this.gui = gui;
        this.blocks = blocks;
        this.state = state;
        this.scoreCount = scoreCount;
        timer = new Timer();
        elapsedSeconds = 0;
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (state.isPlaying()) {
                    blocks.moveDown();
                    elapsedSeconds++;
                    if (timerLabel != null) {
                        timerLabel.setText(String.valueOf(elapsedSeconds));
                    }
                    scoreCount.addScore(10); // Example scoring
                    gui.refresh();
                }
            }
        }, 0, 1000); // 1000ms interval
    }

    public void stop() {
        timer.cancel();
    }

    public void setTimerLabel(JLabel label) {
        this.timerLabel = label;
    }
}
