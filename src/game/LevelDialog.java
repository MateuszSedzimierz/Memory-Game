package game;

import menu.MenuButton;

import javax.swing.*;
import java.awt.*;

public class LevelDialog extends Dialog {
    private Level level;
    private boolean selected;

    public LevelDialog() {
        super("New Game");

        getPanel().add(new SelectLevelPanel(this), BorderLayout.CENTER);
        addNewGameButton();

        pack();
    }

    public void addNewGameButton() {
        MenuButton selectGame = new MenuButton("Play Game", new Color(0x8D8A8D), 36, new Dimension(350, 100));

        selectGame.addActionListener((event) ->
        {
            selected = true;
            setVisible(false);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(selectGame);
        buttonPanel.setOpaque(false);

        getPanel().add(buttonPanel, BorderLayout.SOUTH);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
