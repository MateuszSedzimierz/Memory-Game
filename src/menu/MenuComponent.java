package menu;

import game.BoardComponent;
import game.LevelDialog;
import scores.HighScoresDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuComponent extends JComponent {
    private JPanel mainPanel;
    private Image image;
    private final String BACKGROUND_IMAGE = "../images/Background.jpg";
    private LevelDialog levelDialog;
    private HighScoresDialog scoresDialog;

    public MenuComponent() {
        setLayout(new BorderLayout());

        image = new ImageIcon(getClass().getResource(BACKGROUND_IMAGE)).getImage();

        mainPanel = new JPanel(new GridLayout(5, 1, 20, 40));
        mainPanel.setBorder(new EmptyBorder(40, 180, 80, 180));

        addTitle();
        addStartButton();
        addHighScoreButton();
        addExitButton();

        add(mainPanel, BorderLayout.CENTER);

        mainPanel.setOpaque(false);
    }

    public void addTitle() {
        MenuLabel gameName = new MenuLabel("Memory Game", new Font(Font.MONOSPACED, Font.BOLD, 102), Color.WHITE);
        mainPanel.add(gameName);

        MenuLabel author = new MenuLabel("Mateusz Sędzimierz", new Font(Font.DIALOG, Font.PLAIN, 62), Color.WHITE);
        mainPanel.add(author);
    }

    public void addStartButton() {
        MenuButton newGame = new MenuButton("New Game", new Color(138, 200, 114), 44, null);

        newGame.addActionListener(event ->
        {
            if (levelDialog == null)
                levelDialog = new LevelDialog();

            levelDialog.setLocationRelativeTo(null);
            levelDialog.setSelected(false);
            levelDialog.setVisible(true);

            if (levelDialog.isSelected()) {
                remove(mainPanel);
                add(new BoardComponent(levelDialog.getLevel()));
                revalidate();
                repaint();
            }
        });

        mainPanel.add(newGame);
    }

    public void addHighScoreButton() {
        MenuButton highScores = new MenuButton("High Scores", new Color(132, 197, 200), 44, null);

        highScores.addActionListener(event ->
        {
            if (scoresDialog == null)
                scoresDialog = new HighScoresDialog("High Scores");

            scoresDialog.setLocationRelativeTo(null);
            scoresDialog.setVisible(true);
        });

        mainPanel.add(highScores);
    }

    public void addExitButton() {
        MenuButton exit = new MenuButton("Exit", new Color(200, 100, 100), 44, null);

        exit.addActionListener((event) -> System.exit(0));

        mainPanel.add(exit);
    }

/*
    @Override
    public Dimension getPreferredSize()
    {
        /*
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        return new Dimension(screenWidth / 2, screenHeight / 2);
    }
*/

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null)
            return;

        g.drawImage(image, 0, 0, null);
    }
}
