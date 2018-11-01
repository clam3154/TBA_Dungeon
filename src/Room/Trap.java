package Room;
import Game.Runner;
import People.Person;
public class Trap extends Room
{
    public Trap (int x, int y)
    {
        super(x, y);
    }
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("The room was trapped. You died.");
        Runner.gameOff();
    }
}
