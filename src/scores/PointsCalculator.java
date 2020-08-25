package scores;

import game.Level;

public interface PointsCalculator {                     
    int calculatePoints(int time, int attempts, Level level);
}
