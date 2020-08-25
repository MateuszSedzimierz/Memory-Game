package game;

public class GameTimer extends Thread {
    private int time;
    private String stringTime;
    private boolean timeRunning;
    private final UserPanel userPanel;

    public GameTimer(UserPanel userPanel) {
        this.userPanel = userPanel;
        time = 0;
        timeRunning = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (timeRunning) {
                setStringTime(++time);
                userPanel.setTimeLabelText(stringTime);
            }
        }
    }

    public void setStringTime(int allSeconds) {
        //int hours = allSeconds / 3600;
        int minutes = (allSeconds % 3600) / 60;
        int seconds = allSeconds % 60;

        stringTime = String.format("%02d:%02d", minutes, seconds);
    }

    public String getStringTime() {
        return stringTime;
    }

    public int getTime() {
        return time;
    }

    public void setTimeRunning(boolean timeRunning) {
        this.timeRunning = timeRunning;
    }
}
