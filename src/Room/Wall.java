package Room;

import People.Person;

public class Wall extends Room {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom(Person x) {
        System.out.println("Wall.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
}