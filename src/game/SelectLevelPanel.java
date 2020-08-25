package game;

import menu.MenuLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectLevelPanel extends JPanel {
    private JPanel buttonPanel;
    private ButtonGroup group;
    private LevelDialog owner;
    private final Level DEFAULT_LEVEL = Level.Easy;

    public SelectLevelPanel(LevelDialog owner) {
        this.owner = owner;
        owner.setLevel(DEFAULT_LEVEL);
        setOpaque(false);

        MenuLabel messageLabel = new MenuLabel("Select the level : ", new Font(Font.SANS_SERIF, Font.BOLD, 50), Color.WHITE);
        messageLabel.setBorder(new EmptyBorder(20, 20, 40, 20));
        add(messageLabel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Easy", Level.Easy);
        addRadioButton("Medium", Level.Medium);
        addRadioButton("Hard", Level.Hard);
        addRadioButton("Crazy", Level.Crazy);

        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addRadioButton(String name, Level level) {
        boolean selected = level == DEFAULT_LEVEL;

        JRadioButton button = new JRadioButton(name, selected);
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 40));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setIcon(new ImageIcon(getClass().getResource("../images/Dot.png")));
        button.setSelectedIcon(new ImageIcon(getClass().getResource("../images/TargetDot.png")));
        button.setBorder(new EmptyBorder(0, 30, 0, 30));

        group.add(button);

        button.setOpaque(false);
        buttonPanel.add(button);

        ActionListener listener = event -> owner.setLevel(level);
        button.addActionListener(listener);
    }
}
