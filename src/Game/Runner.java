package Game;

import People.Person;
import Room.Boss;
import Room.Item;
import Room.Monster;
import Room.Room;
import Room.Trap;
import java.util.Scanner;

    public class Runner {


        private static boolean gameOn = true;

        public static void main(String[] args)
        {
            int level;
            int num = 1;
            System.out.println("What level do you want to play on? Easy(1), Medium(2), Hard(3)");
            Scanner start = new Scanner(System.in);
            if(start.nextInt() == 1)
            {
                level = start.nextInt();
            }
            else if (start.nextInt() == 2)
            {
                level = start.nextInt();
            }
            else if (start.nextInt() == 3)
            {
                level = start.nextInt();
            }
            else
            {
                System.out.println("Incorrect input. Level defaults to 1.");
                level = 1;
            }
            if(level == 1)
                num = 6;
            if(level == 2)
                num = 8;
            if(level == 3)
                num = 10;
            Room[][] dungeon = new Room[num][num];
            new Map(num, num);

            //Fill the dungeon with normal rooms
            for (int x = 0; x<dungeon.length; x++)
            {
                for (int y = 0; y < dungeon[x].length; y++)
                {
                    dungeon[x][y] = new Room(x,y);
                }
            }

            //Make all room filled with monsters.
            for (int x = 0; x<dungeon.length; x++)
            {
                for (int y = 0; y < dungeon[x].length; y++)
                {
                    dungeon[x][y] = new Monster(x,y);
                }
            }

            //Create up to 15 random item rooms.
            for(int i = 1; i < 16; i ++)
            {
                int xi = (int) (Math.random() * dungeon.length);
                int yi = (int) (Math.random() * dungeon.length);
                dungeon[xi][yi] = new Item(xi, yi);
            }

            //Create up to 3 random trapped room.
            for(int i = 1; i < 4; i ++)
            {
                int xt = (int) (Math.random() * dungeon.length);
                int yt = (int) (Math.random() * dungeon.length);
                dungeon[xt][yt] = new Trap(xt, yt);
            }

            //Create a random boss room.
            int xb = (int)(Math.random()*dungeon.length);
            int yb = (int)(Math.random()*dungeon.length);
            dungeon[xb][yb] = new Boss(xb, yb);

            //Make the start room empty.
            dungeon[0][0] = new Room(0,0);

            //Setup player 1 and the input scanner
            Person player1 = new Person(0,0);
            dungeon[0][0].enterRoom(player1);
            Scanner in = new Scanner(System.in);
            while(gameOn)
            {
                Map.printBoard();
                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = in.nextLine();
                if (move.equalsIgnoreCase("help"))
                {
                    System.out.println("Use n,s,e,w to move.");
                    System.out.println("Reach the boss room and beat the boss.");
                    System.out.println("Block beats Hit, Hit beats Magic, Magic beats Block.");
                    System.out.println("If you reach 0 health you lose.");
                    System.out.println("If your armor is greater than the enemies attack, they deal no damage.");
                }
                else if(validMove(move, player1, dungeon))
                {
                    System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                    System.out.println("Your stats: Health: " + player1.gethealth() + " Armor: " + player1.getarmor() + " Attack: " + player1.getattack());
                    dungeon[player1.getxLoc()][player1.getyLoc()] = new Room(player1.getxLoc(), player1.getyLoc());
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
