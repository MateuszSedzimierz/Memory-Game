package game;

import menu.MenuButton;
import menu.MenuComponent;
import scores.PointsCalculator;
import scores.ScoreTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinDialog extends JDialog {
    private Image image;
    private static final String IMAGE_PATH = "../images/Win.jpg";
    private JTextField nickField;
    private PointsCalculator pointsCalculator;

    public WinDialog() {
        setTitle("You Win");
        setResizable(false);
        setModal(true);

        addPointsCalculator();

        image = new ImageIcon(getClass().getResource(IMAGE_PATH)).getImage();

        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                if (image == null)
                    return;

                g.drawImage(image, 0, 0, null);
            }
        };

        JPanel newScorePanel = new JPanel();

        nickField = new JTextField("Player", 30);
        nickField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 28));
        nickField.setBorder(new EmptyBorder(10, 10, 10, 10));
        nickField.setPreferredSize(new Dimension(300, 58));
        newScorePanel.add(nickField);

        MenuButton addUser = new MenuButton("Add User", new Color(0x8D8A8D), 28, new Dimension(200, 60));
        addUser.addActionListener(event ->
        {
            setVisible(false);

            int time = UserPanel.getTimer().getTime();
            int attempts = GameEngine.getAttempts();
            Level level = BoardComponent.getLevel();
            int points = pointsCalculator.calculatePoints(time, attempts, level);

            ScoreTableModel.getInstanceOf().addScore(
                    nickField.getText(), level, UserPanel.getTimer().getStringTime(), attempts, points);

            MemoryFrame memory = MemoryFrame.getInstanceOf();
            memory.getContentPane().removeAll();
            memory.add(new MenuComponent());
            memory.revalidate();
            memory.repaint();
        });
        newScorePanel.add(addUser);

        newScorePanel.setOpaque(false);
        mainPanel.add(newScorePanel, BorderLayout.SOUTH);
        add(mainPanel);

        pack();
    }

    public void addPointsCalculator() {
        pointsCalculator = (int time, int attempts, Level level) ->
        {
            switch (level) {
                case Easy:
                    return Math.round((16.0f / (time + attempts)) * 100);
                case Medium:
                    return Math.round((36.0f / (time / 10f + attempts / 10f)) * 200);
                case Hard:
                    return Math.round((64.0f / (time / 100f + attempts / 10f)) * 300);
                case Crazy:
                    return Math.round((100.0f / (time / 1000f + attempts / 10f)) * 400);
            }
            return 0;
        };
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
