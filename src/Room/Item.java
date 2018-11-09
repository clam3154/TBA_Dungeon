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
    private String[] randomitem = {("Increase Health"), ("Increase Health"), ("Piece of Armor"), ("Attack Power Up")};
    @Override
    public void enterRoom(Person x)
    {
        int i = (int) (Math.random() * randomitem.length);
        System.out.println("You found a chest.");
        System.out.println("You got a " + randomitem[i] + ".");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(i <= 1)
            x.sethealth(x.gethealth()+6);
        if(i == 2)
            x.setarmor(x.getarmor()+1);
        if(i == 3)
            x.setattack(x.getattack()+1);
    }
}
