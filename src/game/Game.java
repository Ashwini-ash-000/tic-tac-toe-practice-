package game;

import java.util.Scanner;
import board.Board;
import player.Player;

public class Game {
    Player[] players;
    Board board;
    int noOfMoves;
    int turn;
    Boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players ,Board board)
    {
        this.board = board;
        this.players = players;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder z=new StringBuilder();
        StringBuilder c=new StringBuilder();

        for(int i=0;i<board.size;i++)
        {
            z.append('O');
            c.append('X');
        }

        this.zero=z.toString();
        this.cross=c.toString();
    }

    @SuppressWarnings("resource")
    public int getIdx()
    {
        int size=board.size;

        while(true)
        {
            Scanner scn=new Scanner(System.in);
            System.out.println(players[turn].getPlayerName()+" Enter the position: ");
            int pos = scn.nextInt()-1;

            int row = pos/size;
            int col = pos%size;

            if(row < 0 || row>=size || col < 0 || col >= size)
            {
                System.out.println("Invalid entry\nPlease enter the valid position:");
                continue;
            }

            if(board.matrix[row][col] != '#')
            {
                System.out.println("The cell is already filled\nPlease enter the valid position:");
                continue;
            }
            return pos;
        }
    }

    public Boolean getCombination()
    {
        int sz=board.size;

        for(int i=0;i<sz;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<sz;j++)
            {
                sb.append(board.matrix[i][j]);
            }
            String pattern = sb.toString();

            if(pattern.equals(zero) || pattern.equals(cross))
            {
                return true;
            }
        }

        for(int i=0;i<sz;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<sz;j++)
            {
                sb.append(board.matrix[j][i]);
            }
            String pattern = sb.toString();
            
            if(pattern.equals(zero) || pattern.equals(cross))
            {
                return true;
            }
        }

        int i,j;
        StringBuilder sb=new StringBuilder();

        i=0;
        j=0;

        while(i < sz)
        {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();
            
            if(pattern.equals(zero) || pattern.equals(cross))
            {
                return true;
            }

        
        i=0;
        j=sz-1;
        sb=new StringBuilder();

        while(j>=0)
        {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }

        pattern = sb.toString();
            
        if(pattern.equals(zero) || pattern.equals(cross))
        {
            return true;
        }

        return false;
    }

    public void play()
    {
        board.printBoardConfig();
        int sz=board.size;

        while(noOfMoves < sz*sz)
        {

            noOfMoves++;

            int pos = getIdx();

            int row = pos/sz;
            int col = pos%sz;

            board.matrix[row][col] = players[turn].getPlayerSymbol();

            if(noOfMoves >= sz*sz)
            {
                System.out.println("Game Draw");
                return;
            }

            if(noOfMoves >= 2*sz-1 && getCombination()==true)
            {
                board.printBoardConfig();
                System.out.println("Winner is "+players[turn].getPlayerName());
                return;
            }

            turn = (turn+1)%2;
            board.printBoardConfig();
        }
    }
}
