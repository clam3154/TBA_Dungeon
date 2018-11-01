package Game;
import People.Person;
import Room.Boss;
import Room.Item;
import Room.Monster;
import Room.Room;
import Room.Trap;
import Room.Wall;

import java.util.Scanner;

    public class Runner {


        private static boolean gameOn = true;

        public static void main(String[] args)
        {
            Room[][] building = new Room[14][14];

            //Fill the building with normal rooms
            for (int x = 0; x<building.length; x++)
            {
                for (int y = 0; y < building[x].length; y++)
                {
                    building[x][y] = new Room(x,y);
                }
            }

            //Create a random boss room.
            int xb = (int)(Math.random()*building.length);
            int yb = (int)(Math.random()*building.length);
            building[xb][yb] = new Boss(xb, yb);

            //Create a random trapped room.
            int xt = (int)(Math.random()*building.length);
            int yt = (int)(Math.random()*building.length);
            if(xb == xt && yb == yt)
            {
                while(xb == xt && yb == yt)
                {
                    xt = (int)(Math.random()*building.length);
                    yt = (int)(Math.random()*building.length);
                }
            }
            else
            {
                building[xt][yt] = new Trap(xt, yt);
            }

            //Create up to 7 random wall.
            for(int i = 1; i < 7; i ++)
            {
                int xw = (int) (Math.random() * building.length);
                int yw = (int) (Math.random() * building.length);
                if (xb == xw && yb == yw || xt == xw && yt == yw)
                {
                    while (xb == xw && yb == yw || xt == xw && yt == yw)
                    {
                        xw = (int) (Math.random() * building.length);
                        yw = (int) (Math.random() * building.length);
                    }
                } else {
                    building[xw][yw] = new Wall(xw, yw);
                }
            }

            //Setup player 1 and the input scanner
            Person player1 = new Person(0,0);
            building[0][0].enterRoom(player1);
            Scanner in = new Scanner(System.in);
            while(gameOn)
            {
                String row = "";
                for(int i=0; i<building.length; i++)
                {
                    for(int j=0; j<building[i].length; j++)
                    {
                        row += building[i][j];
                    }
                    row += "\n";
                }
                System.out.println(row);
                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = in.nextLine();
                if(validMove(move, player1, building))
                {
                    building[player1.getxLoc()][player1.getyLoc()] = "[O]";

                }
                else {
                    System.out.println("Please choose a valid move.");
                }
            }
            in.close();
        }

        /**
         * Checks that the movement chosen is within the valid game map.
         * @param move the move chosen
         * @param p person moving
         * @param map the 2D array of rooms
         * @return
         */
        public static boolean validMove(String move, Person p, Room[][] map)
        {
            move = move.toLowerCase().trim();
            switch (move) {
                case "n":
                    if (p.getxLoc() > 0)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                case "e":
                    if (p.getyLoc()< map[p.getyLoc()].length -1)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }

                case "s":
                    if (p.getxLoc() < map.length - 1)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }

                case "w":
                    if (p.getyLoc() > 0)
                    {
                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                default:
                    break;

            }
            return true;
        }
        public static void gameOff()
        {
            gameOn = false;
        }
}
