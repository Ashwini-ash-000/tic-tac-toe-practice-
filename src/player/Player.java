package player;

public class Player {
    private String name;
    private char symbol;

    public Player(String name , char symbol)
    {
        this.name = name;
        this.symbol = symbol;
    }

    public String getPlayerName()
    {
        return name;
    }

    public char getPlayerSymbol()
    {
        return symbol;
    }
}
