package board;

public class Board {
    public int size;
    public char matrix[][];

    public Board(int size)
    {
        this.size=size;
        matrix =new char[size][size];
    }

    public void getDefaultSymbol(char defaultSymbol)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                matrix[i][j]=defaultSymbol;
            }
        }
    }

    public void printBoardConfig()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
