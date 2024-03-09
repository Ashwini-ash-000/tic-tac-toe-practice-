import board.Board;
import player.Player;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Practice Tic Tac Toe");

        Board b= new Board(3);

        b.getDefaultSymbol('#');

        Player p1=new Player("Ajay", 'X');
        Player p2=new Player("Ashwini", 'O');

        Game g = new Game(new Player[] {p1,p2}, b);

        g.play();
    }
}
