import javax.swing.JLabel;

public class ScoreCount {
    private int score;
    private JLabel scoreLabel; // For displaying score

    public ScoreCount()
    {
        if(singleton != null)
        {
            System.err.println("ScoreCount is a singleton, don't make more than one.");
        }
        singleton = this;
        score = 0;
    }

    private static ScoreCount singleton;


    public int getScore() {
        return score;
    }

    public static void addScore(int points) {
        singleton.score += points;
        if (singleton.scoreLabel != null) {
            singleton.scoreLabel.setText(String.valueOf(singleton.score));
        }
    }

    public void resetScore() {
        score = 0;
        if (scoreLabel != null) {
            scoreLabel.setText(String.valueOf(score));
        }
    }

    public void setScoreLabel(JLabel label) {
        this.scoreLabel = label;
    }
}
