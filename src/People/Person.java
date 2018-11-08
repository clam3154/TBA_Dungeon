package People;
/**
 * People represents the player as they move through the game.
 */
public class Person {
    int xLoc, yLoc;
    int health, armor, attack;
    String[] items = new String[15];

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

    public Person(int health, int armor, int attack) {
        this.health = health;
        this.armor = armor;
        this.attack = attack;
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

    public Person(String[] items)
    {
        this.items = items;
    }

    public String getitems() {
        String str = "";
        for(int i=0; i<items.length; i++) {
            if (items[i] != null) {
                str += items[i];
            }
        }
        return str;
    }

    public void storeitems(String item) {
        for(int i=0; i<items.length; i++) {
            if (items[i].equals(null)) {
                items[i] = item;
            }
        }
    }

}