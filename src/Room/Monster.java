package Room;
import People.Person;

public class Monster extends Room{
    public Monster(int x, int y)
    {
        super(x, y);
    }
    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        String[] randommonster = {("zombie"), ("husk"), ("ghoul")};
        int i = (int) (Math.random() * randommonster.length);
        System.out.println("You encountered a " + randommonster[i] + ".");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
}
