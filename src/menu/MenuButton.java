package menu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuButton extends JButton {
    public MenuButton(String name, Color color, int fontSize, Dimension size) {
        super(name);

        setFont(new Font(Font.SERIF, Font.BOLD, fontSize));
        setForeground(Color.WHITE);

        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        setBorder(BorderFactory.createCompoundBorder(raisedBevel, loweredBevel));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(color);
        setPreferredSize(size);
    }
}
