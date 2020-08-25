package scores;

import javax.swing.*;
import java.awt.*;

public class ScoreTable extends JTable {
    private final ScoreTableModel tableModel;

    public ScoreTable() {
        tableModel = ScoreTableModel.getInstanceOf();
        setModel(tableModel);

        setDefaultRenderer(String.class, new ScoreTableRenderer());

        setOpaque(false);
        setRowHeight(40);

        //Creating column names view
        getTableHeader().setFont(new Font(Font.DIALOG, Font.BOLD, 32));
        getTableHeader().setForeground(Color.WHITE);
        getTableHeader().setBackground(new Color(138, 200, 114));
    }
}
