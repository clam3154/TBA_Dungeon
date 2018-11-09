package People;
/**
 * People represents the player as they move through the game.
 */
public class Person implements Stats{
    int xLoc, yLoc;
    int health = 20, armor = 0, attack = 1;

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public Person(int xLoc, int yLoc) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public int gethealth() {
        return health;
    }

    public void sethealth(int health) {
        this.health = health;
    }

    public int getarmor() {
        return armor;
    }

    public void setarmor(int armor) {
        this.armor = armor;
    }

    public int getattack() {
        return attack;
    }

    public void setattack(int attack) {
        this.attack = attack;
    }
}