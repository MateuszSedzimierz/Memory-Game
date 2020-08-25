package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoardComponent extends JComponent {
    private CardsPanel cardsPanel;
    private UserPanel userPanel;
    private static Level level;

    public BoardComponent(Level level) {
        setLayout(new BorderLayout());
        BoardComponent.level = level;
        cardsPanel = new CardsPanel(level);
        userPanel = new UserPanel(cardsPanel.getCards());

        add(cardsPanel, BorderLayout.CENTER);
        cardsPanel.setOpaque(false);

        add(userPanel, BorderLayout.SOUTH);

        GameEngine gameEngine = new GameEngine(userPanel);
        gameEngine.start();
        ninjaMode();
    }

    /**
     * TOP SECRET
     */
    public void ninjaMode() {
        Action ninjaAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (Card c : cardsPanel.getCards())
                    c.setNinjaMode();
            }
        };

        cardsPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift N"), "ninja");
        cardsPanel.getActionMap().put("ninja", ninjaAction);
    }

    public static Level getLevel() {
        return level;
    }
}
