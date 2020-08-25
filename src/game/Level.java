package game;

public enum Level {
    Easy(16),        //4x4
    Medium(36),      //6x6
    Hard(64),        //8x8
    Crazy(100);      //10x10

    private final int howManyCards;

    Level(int howManyCards) {
        this.howManyCards = howManyCards;
    }

    public int getHowManyCards() {
        return howManyCards;
    }
}
