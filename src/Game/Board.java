package Game;

import Room.Room;

public class Board
{
    private Room[][] board;

    public Board(Room[][] board)
    {
        this.board = board;
    }
    public Board(int height, int width)
    {
        board = new Room[height][width];
    }
    public void printBoard()
    {
        for(Room[] i : board)
        {
            for(Room j : i)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
