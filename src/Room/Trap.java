package Room;
import People.Person;
public class Trap extends Room
{
    public Trap (int x, int y)
    {
        super(x, y);
    }
    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        System.out.println("The room was trapped. You lost 20 health.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }
}
