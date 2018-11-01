package Room;
import Game.Runner;
import People.Person;
public class Boss extends Room
{
        public Boss(int x, int y)
        {
            super(x, y);
        }
        /**
         * Triggers the game ending conditions.
         * @param x the Person entering
         */
        @Override
        public void enterRoom(Person x) {
            System.out.println("You found the Boss room.");
            occupant = x;
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            Runner.gameOff();
        }
}
