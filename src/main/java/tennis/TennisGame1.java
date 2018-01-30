package tennis;

public class TennisGame1 implements TennisGame {

    private PlayerScore playerScore1;
    private PlayerScore playerScore2;

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
        int tempScore = 0;
        if (this.playerScore1.getScore() == this.playerScore2.getScore()) {
            score = computeScoreWhenPlayersHaveTheSame();
        } else if (this.playerScore1.getScore() >= 4 || this.playerScore2.getScore() >= 4) {
            score = computeScoreWhenBothHaveFourPointsOrMore();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = this.playerScore1.getScore();
                else {
                    score += "-";
                    tempScore = this.playerScore2.getScore();
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String computeScoreWhenPlayersHaveTheSame() {
        String score;
        switch (this.playerScore1.getScore()) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private String computeScoreWhenBothHaveFourPointsOrMore(){
        String score;
        int minusResult = this.playerScore1.getScore() - this.playerScore2.getScore();
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}
