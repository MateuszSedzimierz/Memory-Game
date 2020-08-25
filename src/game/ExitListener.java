package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        UserPanel.getTimer().setTimeRunning(false);
        GameEngine.setPlaying(false);

        ExitDialog exitDialog = new ExitDialog("Exit");

        exitDialog.setLocationRelativeTo(null);
        exitDialog.setVisible(true);
    }
}
