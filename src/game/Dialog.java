package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class Dialog extends JDialog {
    private Image image;
    private static final String DIALOG_BACKGROUND = "../images/Dialog.jpg";
    private JPanel panel;

    public Dialog(String title) {
        setTitle(title);
        setResizable(false);
        setModal(true);

        image = new ImageIcon(getClass().getResource(DIALOG_BACKGROUND)).getImage();

        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                if (image == null)
                    return;

                g.drawImage(image, 0, 0, null);
            }
        };

        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        add(panel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 400);
    }
}
