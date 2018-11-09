package Room;
import People.Person;

import java.util.Scanner;

public class Monster extends Room{
    public Monster(int x, int y)
    {
        super(x, y);
    }
    int mhealth, mattack, dmg;
    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        String[] randommonster = {("zombie"), ("husk"), ("ghoul")};
        String[] randommove = {("block"), ("hit"), ("spell")};
        int i = (int) (Math.random() * randommonster.length);
        System.out.println("You encountered a " + randommonster[i] + ".");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(i == 0)
        {
            mhealth = 1;
            mattack = 1;
        }
        if(i == 1)
        {
            mhealth = 3;
            mattack = 2;
        }
        if(i == 2)
        {
            mhealth = 5;
            mattack = 3;
        }
        dmg = x.getarmor()-mattack;
        if(dmg < 0)
            dmg = 0;
        while(mhealth > 0 || x.gethealth() > 0)
        {
            int moves = (int) (Math.random() * randommove.length);
            Scanner mov = new Scanner(System.in);
            String attack = mov.nextLine();
            if(attack.equalsIgnoreCase("block")|| attack.equalsIgnoreCase("hit") || attack.equalsIgnoreCase("magic"))
            {

            }
            else
            {
                attack = randommove[(int) (Math.random() * randommove.length)];
            }
            if(attack.equalsIgnoreCase(randommove[moves]))
            {
                System.out.println("Draw, both sides used " + randommove[moves]);
            }
            if(attack.equalsIgnoreCase("block") && moves == 1)
            {
                mhealth -= x.getattack();
            }
            if(attack.equalsIgnoreCase("hit") && moves == 2)
            {
                mhealth -= x.getattack();
            }
            if(attack.equalsIgnoreCase("magic") && moves == 0)
            {
                mhealth -= x.getattack();
            }
            if(attack.equalsIgnoreCase("block") && moves == 2)
            {
                x.sethealth(x.gethealth()-dmg);
            }
            if(attack.equalsIgnoreCase("magic") && moves == 1)
            {
                x.sethealth(x.gethealth()-dmg);
            }
            if(attack.equalsIgnoreCase("hit") && moves == 0)
            {
                x.sethealth(x.gethealth()-dmg);
            }
        }
        if(mhealth > 0)
        {
            System.out.println("You defeated a " + randommonster[i] + ".");
        }
        if(x.gethealth() > 0)
        {
            System.out.println("Game over! You have died.");
        }
    }
}
