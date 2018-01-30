package tennis;

/**
 * Created by retina on 30/01/2018.
 */
public class PlayerScore {
    private String playerName;
    private int score;

    public PlayerScore(String playerName) {
        if (playerName == null) {
            throw new NullPointerException("PlayerScore playerName could not be null");
        }
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isNamed(String name) {
        return this.playerName.equals(name);
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        this.score++;
    }
}
