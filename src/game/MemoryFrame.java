package game;

import menu.MenuComponent;

import javax.swing.*;
import java.awt.*;

public class MemoryFrame extends JFrame {
    private static MemoryFrame frame;

    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 1024;

    private MemoryFrame() {
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("../images/Shark.png")).getImage());

        add(new MenuComponent());
        //pack();

        setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static MemoryFrame getInstanceOf() {
        if (frame == null)
            frame = new MemoryFrame();

        return frame;
    }
}
