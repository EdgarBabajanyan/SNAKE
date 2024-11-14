public class TetrisState {
    private boolean playing;

    public TetrisState() {
        playing = true;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
