import game.MemoryFrame;

import java.awt.*;

public class MemoryGame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            MemoryFrame frame = MemoryFrame.getInstanceOf();
        });
    }
}
