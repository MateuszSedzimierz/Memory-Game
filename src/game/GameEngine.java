package game;

import java.util.ArrayList;
import java.util.List;

public class GameEngine extends Thread {
    private static boolean playing;
    private static int attempts;
    private int goodPairs;

    private UserPanel userPanel;

    public GameEngine(UserPanel userPanel) {
        this.userPanel = userPanel;
        attempts = 0;
        goodPairs = 0;
        playing = true;
    }

    public void run() {
        List<Card> cards = userPanel.getCards();

        while (true) {
            int first = -1;
            int second = -1;
            int clicked = 0;

            for (int i = 0; i < cards.size() && clicked < 2; i++) {
                if (cards.get(i).isClicked()) {
                    if (first == -1)
                        first = i;
                    else
                        second = i;

                    clicked++;
                }
            }

            if (clicked == 2) {

                for (Card card : cards)
                    card.setEnabled(false);

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (cards.get(first).getColor().equals(cards.get(second).getColor())) {
                    goodPairs++;
                    cards.get(first).setVisible(false);
                    cards.get(second).setVisible(false);
                }

                if (playing) {
                    attempts++;
                    userPanel.setAttemptsLabelText(String.format("%03d", attempts));

                    for (Card card : cards)
                        card.setPrimaryCard();
                }
            }

            if (goodPairs == BoardComponent.getLevel().getHowManyCards() / 2) {
                UserPanel.getTimer().setTimeRunning(false);
                playing = false;
                win();
                goodPairs = 0;
            }
        }
    }

    public static void setPlaying(boolean playing) {
        GameEngine.playing = playing;
    }

    public static int getAttempts() {
        return attempts;
    }

    public void win() {
        WinDialog winDialog = new WinDialog();
        winDialog.setLocationRelativeTo(null);
        winDialog.setVisible(true);
    }
}
