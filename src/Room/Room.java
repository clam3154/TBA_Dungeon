package Room;

import People.Person;

public class Room {
    Person occupant;
    int xLoc,yLoc;
    String toString;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the People entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You enter a empty room.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }
}
