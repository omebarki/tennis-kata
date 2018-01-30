package tennis;

public class TennisGame1 implements TennisGame {

    private PlayerScore playerScore1;
    private PlayerScore playerScore2;

    private static String[] EQUAL_CASES_SCORES = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
    private static String[] LESS_THAN_FOUR_SCORES_NAMES = {"Love","Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.playerScore1 = new PlayerScore(player1Name);
        this.playerScore2 = new PlayerScore(player2Name);
    }

    public void wonPoint(String playerName) {
        if (this.playerScore1.isNamed(playerName))
            this.playerScore1.addPoint();
        else
            this.playerScore2.addPoint();
    }

    public String getScore() {
        String score = "";
        if (this.playerScore1.getScore() == this.playerScore2.getScore()) {
            score = computeScoreWhenPlayersHaveTheSame();
        } else if (this.playerScore1.getScore() >= 4 || this.playerScore2.getScore() >= 4) {
            score = computeScoreWhenBothHaveFourPointsOrMore();
        } else {
            score = computeScoreInTheRestCases();
        }
        return score;
    }

    private String computeScoreWhenPlayersHaveTheSame() {
        int score = this.playerScore1.getScore();
        return (score < EQUAL_CASES_SCORES.length) ? EQUAL_CASES_SCORES[score] : EQUAL_CASES_SCORES[EQUAL_CASES_SCORES.length - 1];
    }

    private String computeScoreWhenBothHaveFourPointsOrMore() {
        String score;
        int player1MinusPlayer2Score = this.playerScore1.getScore() - this.playerScore2.getScore();
        String playerNameWithBestScore = (player1MinusPlayer2Score > 0) ? this.playerScore1.getPlayerName() : this.playerScore2.getPlayerName();
        if (Math.abs(player1MinusPlayer2Score) == 1) {
            score = "Advantage " + playerNameWithBestScore;
        } else {
            score = "Win for " + playerNameWithBestScore;
        }
        return score;
    }

    private String computeScoreInTheRestCases() {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = this.playerScore1.getScore();
            else {
                score += "-";
                tempScore = this.playerScore2.getScore();
            }
            score += LESS_THAN_FOUR_SCORES_NAMES[tempScore];
        }
        return score;
    }
}
