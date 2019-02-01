package Game;

import Room.Room;

public class Map
{
    private static Room[][] board;

    public Map(Room[][] board)
    {
        this.board = board;
    }
    public Map(int height, int width)
    {
        board = new Room[height][width];
    }
    public static void printBoard()
    {
        for(Room[] i : board)
        {
            for(Room j : i)
            {
                System.out.print("[]");
            }
            System.out.println();
        }
    }
    public String toString()
    {
        String str = "";
        for(Room[] i : board)
        {
            for(Room j : i)
            {
                str += "[" + j + "]";
            }
            str += "\n";
        }
        return str;
    }
}