package scores;

import game.Level;

import java.io.Serializable;

public class Score implements Comparable<Score>, Serializable {
    private String nick;
    private Level level;
    private String time;
    private int attempts;
    private int points;

    public Score(String nick, Level level, String time, int attempts, int points) {
        this.nick = nick;
        this.level = level;
        this.time = time;
        this.attempts = attempts;
        this.points = points;
    }

    public String getNick() {
        return nick;
    }

    public Level getLevel() {
        return level;
    }

    public String getTime() {
        return time;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(Score o) {
        return o.getPoints() - this.getPoints();
    }
}
