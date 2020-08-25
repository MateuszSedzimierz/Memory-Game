package scores;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HighScoresDialog extends JDialog {
    private final Image image;
    private static final String DIALOG_BACKGROUND = "../images/ScoresDialog.jpg";

    public HighScoresDialog(String title) {
        setTitle(title);
        setResizable(false);
        setModal(true);

        image = new ImageIcon(getClass().getResource(DIALOG_BACKGROUND)).getImage();

        ScoreTable scoreTable = new ScoreTable();

        JScrollPane scroll = new JScrollPane(scoreTable) {
            @Override
            protected void paintComponent(Graphics g) {
                if (image == null)
                    return;

                g.drawImage(image, 0, 0, null);
            }
        };

        scroll.setOpaque(false);
        scroll.setBorder(new EmptyBorder(30, 30, 30, 30));
        scroll.getViewport().setOpaque(false);

        add(scroll);

        pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 647);
    }
}
