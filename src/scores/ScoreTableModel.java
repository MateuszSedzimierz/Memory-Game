package scores;

import game.Level;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ScoreTableModel with using a Singleton
 */
public class ScoreTableModel extends AbstractTableModel {
    private List<Score> scores;
    private final String[] columnNames = {"NICK", "LEVEL", "TIME", "TRIALS", "SCORE"};
    private static ScoreTableModel scoreTableModel;

    private ScoreTableModel() {
        readScores();
    }

    public static ScoreTableModel getInstanceOf() {
        if (scoreTableModel == null)
            scoreTableModel = new ScoreTableModel();

        return scoreTableModel;
    }

    @Override
    public int getRowCount() {
        return scores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Sorting scores
        Collections.sort(scores);

        Score score = scores.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return score.getNick();
            case 1:
                return score.getLevel();
            case 2:
                return score.getTime();
            case 3:
                return score.getAttempts();
            case 4:
                return score.getPoints();
        }

        return null;
    }

    /**
     * Adding new score to table
     */
    public void addScore(String nick, Level level, String time, int attempts, int points) {
        scores.add(new Score(nick, level, time, attempts, points));
        writeScores();
    }

    /**
     * Writing scores table to file
     */
    public void writeScores() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("scores.bin"));
            outputStream.writeObject(scores);
            outputStream.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "An unexpected error occurred :(", "Error Adding User",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Reading high scores from file
     */
    public void readScores() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("scores.bin"));
            scores = (ArrayList<Score>) inputStream.readObject();
            inputStream.close();

        } catch (Exception e) {
            scores = new ArrayList<>();

            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "An unexpected error occurred :(",
                    "Reading High Scores", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
