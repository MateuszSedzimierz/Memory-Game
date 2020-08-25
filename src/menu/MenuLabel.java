package menu;

import javax.swing.*;
import java.awt.*;

public class MenuLabel extends JLabel {
    public MenuLabel(String text, Font font, Color fontColor) {
        setText(text);
        setFont(font);
        setForeground(fontColor);

        setHorizontalAlignment(JLabel.CENTER);
    }
}
