package scores;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ScoreTableRenderer extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String s = value.toString();

        this.setText(s);
        this.setForeground(Color.WHITE);
        this.setOpaque(false);
        this.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));

        return this;
    }
}
