package Room;
import People.Person;

public class Item extends Room{
    public Item(int x, int y)
    {
        super(x, y);
    }
    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x)
    {
        String[] randomitem = {("Health Potion"), ("Leather Armor"), ("Iron Armor"), ("Attack Power Up"), ("Drill")};
        int i = (int) (Math.random() * randomitem.length);
        System.out.println("You found a chest.");
        System.out.println("You got a " + randomitem[i] + ".");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
}
