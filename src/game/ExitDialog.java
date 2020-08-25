package game;

import menu.MenuButton;
import menu.MenuComponent;
import menu.MenuLabel;

import javax.swing.*;
import java.awt.*;

public class ExitDialog extends Dialog {
    private MenuLabel messageLabel;
    private MenuButton continueButton;
    private MenuButton goMenuButton;
    private MenuButton quitGameButton;
    private final Dimension BUTTON_SIZE = new Dimension(300, 60);

    public ExitDialog(String title) {
        super(title);

        setUndecorated(true);
        String message = "What do you want to do ?";
        messageLabel = new MenuLabel(message, new Font(Font.SANS_SERIF, Font.BOLD, 50), Color.WHITE);

        super.getPanel().add(messageLabel, BorderLayout.CENTER);
        addButtonPanel();

        pack();
    }

    public void addButtonPanel() {
        continueButton = new MenuButton("Continue game", new Color(138, 200, 114), 28, BUTTON_SIZE);
        goMenuButton = new MenuButton("Return to menu", new Color(132, 197, 200), 28, BUTTON_SIZE);
        quitGameButton = new MenuButton("Quit game", new Color(200, 100, 100), 28, BUTTON_SIZE);

        continueButton.addActionListener((event) ->
        {
            setVisible(false);
            if (!UserPanel.isPause()) {
                GameEngine.setPlaying(true);
                UserPanel.getTimer().setTimeRunning(true);
            }
        });

        goMenuButton.addActionListener((event) ->
        {
            setVisible(false);
            MemoryFrame memory = MemoryFrame.getInstanceOf();
            memory.getContentPane().removeAll();
            memory.add(new MenuComponent());
            memory.revalidate();
            memory.repaint();
        });

        quitGameButton.addActionListener(event -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(continueButton);
        buttonPanel.add(goMenuButton);
        buttonPanel.add(quitGameButton);
        buttonPanel.setOpaque(false);
        super.getPanel().add(buttonPanel, BorderLayout.SOUTH);
    }
}
