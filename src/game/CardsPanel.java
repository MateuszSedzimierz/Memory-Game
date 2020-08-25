package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsPanel extends JPanel {
    private List<Card> cards;
    private Level level;
    private int howManyCards;

    public CardsPanel(Level level) {
        cards = new ArrayList<>();
        this.level = level;
        howManyCards = level.getHowManyCards();

        createBoardLayout();
        createCards();
        addCards();
    }

    public void createBoardLayout() {
        switch (level) {
            case Easy:
                setLayout(new GridLayout(4, 4, 20, 20));
                setBorder(new EmptyBorder(20, 205, 10, 205));
                break;
            case Medium:
                setLayout(new GridLayout(6, 6, 13, 13));
                setBorder(new EmptyBorder(15, 205, 10, 205));
                break;
            case Hard:
                setLayout(new GridLayout(8, 8, 8, 8));
                setBorder(new EmptyBorder(15, 210, 10, 210));
                break;
            case Crazy:
                setLayout(new GridLayout(10, 10, 5, 5));
                setBorder(new EmptyBorder(15, 210, 10, 210));
                break;
        }
    }

    public void createCards() {
        for (int i = 0; i < howManyCards; i++) {
            Card card = new Card(howManyCards);
            cards.add(card);
        }

        //Add color to cards
        int indexOfColor = 0;

        for (int i = 0; i < howManyCards; i += 2) {
            cards.get(i).setColor(CardColor.getColorCard(indexOfColor));
            cards.get(i + 1).setColor(CardColor.getColorCard(indexOfColor));
            indexOfColor++;
        }
    }

    /**
     * Random adding cards to board
     */
    public void addCards() {
        int counter = 0;
        Random random = new Random();
        int i;

        while (counter < howManyCards) {
            i = random.nextInt(howManyCards);

            if (!cards.get(i).isAddedToBoard()) {
                add(cards.get(i));
                cards.get(i).setAddedToBoard(true);
                counter++;
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
