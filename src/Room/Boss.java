package Room;
import Game.Runner;
import People.Person;

import java.util.Scanner;

public class Boss extends Room
{
    public Boss(int x, int y)
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
         String[] randommove = {("block"), ("hit"), ("spell")};
         System.out.println("You found the Boss room.");
         System.out.println("You encountered a Lich.");
         occupant = x;
         x.setxLoc(this.xLoc);
         x.setyLoc(this.yLoc);
         mhealth = 20;
         mattack = 4;
         dmg = x.getarmor()-mattack;
         if(dmg < 0)
             dmg = 0;
         while (mhealth > 0 || x.gethealth() > 0) {
             int moves = (int) (Math.random() * randommove.length);
             Scanner mov = new Scanner(System.in);
             String attack = mov.nextLine();
             if (attack.equalsIgnoreCase("block") || attack.equalsIgnoreCase("hit") || attack.equalsIgnoreCase("magic")) {
             } else {
                 attack = randommove[(int) (Math.random() * randommove.length)];
             }
             if (attack.equalsIgnoreCase(randommove[moves])) {
                 System.out.println("Draw, both sides used " + randommove[moves]);
             }
             if (attack.equalsIgnoreCase("block") && moves == 1) {
                 mhealth -= x.getattack();
             }
             if (attack.equalsIgnoreCase("hit") && moves == 2) {
                 mhealth -= x.getattack();
             }
             if (attack.equalsIgnoreCase("magic") && moves == 0) {
                 mhealth -= x.getattack();
             }
             if (attack.equalsIgnoreCase("block") && moves == 2) {
                 x.sethealth(x.gethealth() - dmg);
             }
             if (attack.equalsIgnoreCase("magic") && moves == 1) {
                 x.sethealth(x.gethealth() - dmg);
             }
             if (attack.equalsIgnoreCase("hit") && moves == 0) {
                 x.sethealth(x.gethealth() - dmg);
             }
         }
         if(mhealth > 0)
         {
             System.out.println("You defeated the Lich.");
             System.out.println("Congratulation! You won!");
         }
         if(x.gethealth() > 0)
         {
             System.out.println("Game over! You have died.");
         }
         Runner.gameOff();
     }
}
