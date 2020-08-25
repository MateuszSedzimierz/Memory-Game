package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class UserPanel extends JPanel {
    private JLabel attemptsLabel;
    private JLabel timeLabel;
    private JButton playPauseButton;
    private ImageIcon playIcon;
    private ImageIcon pauseIcon;
    private static boolean pause;
    private List<Card> cards;
    private static GameTimer timer;

    public UserPanel(List<Card> cards) {
        this.cards = cards;

        setOpaque(false);
        setLayout(new BorderLayout());

        playPauseButton = new JButton();
        playIcon = new ImageIcon(getClass().getResource("../images/PlayButton.png"));
        pauseIcon = new ImageIcon(getClass().getResource("../images/PauseButton.png"));

        creatingPanel();

        pause = false;
        timer = new GameTimer(this);
        timer.start();
    }

    public void creatingPanel() {
        addAttemptsLabel();
        addTimeLabelStyle();

        JButton exitButton = new JButton();

        addButton(playPauseButton, "PauseButton.png", (event) ->
        {
            pause = !pause;
            if (pause) {
                timer.setTimeRunning(false);
                GameEngine.setPlaying(false);

                playPauseButton.setIcon(playIcon);

                for (Card card : cards)
                    card.setEnabled(false);
            } else {
                timer.setTimeRunning(true);
                GameEngine.setPlaying(true);

                playPauseButton.setIcon(pauseIcon);

                for (Card card : cards)
                    if (!card.isClicked())
                        card.setEnabled(true);
            }
        });

        addButton(exitButton, "Exit.png", new ExitListener());

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(playPauseButton);
        buttonsPanel.add(exitButton);

        add(buttonsPanel, BorderLayout.LINE_END);
    }

    public void addAttemptsLabel() {
        attemptsLabel = new JLabel();

        attemptsLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        attemptsLabel.setText("Attempts: 000");
        attemptsLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
        attemptsLabel.setOpaque(false);

        attemptsLabel.setForeground(Color.WHITE);

        add(attemptsLabel, BorderLayout.LINE_START);
    }


    public void addTimeLabelStyle() {
        timeLabel = new JLabel();
        timeLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(false);
        timeLabel.setBorder(new EmptyBorder(0, 140, 0, 0));
        timeLabel.setText("00:00");

        add(timeLabel, BorderLayout.CENTER);
    }

    public void addButton(JButton button, String iconName, ActionListener listener) {
        button.setIcon(new ImageIcon(getClass().getResource("../images/" + iconName)));

        button.setBackground(Color.WHITE);
        button.setBorder(new EmptyBorder(0, 5, 15, 10));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(listener);
        button.setOpaque(false);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setTimeLabelText(String text) {
        timeLabel.setText(text);
    }

    public void setAttemptsLabelText(String text) {
        attemptsLabel.setText("Attempts: " + text);
    }

    public static GameTimer getTimer() {
        return timer;
    }

    public static boolean isPause() {
        return pause;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 90);
    }
}

