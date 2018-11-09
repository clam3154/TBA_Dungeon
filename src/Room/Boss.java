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
         String[] randommove = {("block"), ("hit"), ("magic")};
         System.out.println("You found the Boss room.");
         System.out.println("You encountered a Lich.");
         occupant = x;
         x.setxLoc(this.xLoc);
         x.setyLoc(this.yLoc);
         mhealth = 20;
         mattack = 4;
         dmg = mattack-x.getarmor();
         if(dmg < 0)
             dmg = 0;
         while (mhealth > 0 && x.gethealth() > 0) {
             System.out.println("Block, Hit, or Magic");
             int moves = (int) (Math.random() * randommove.length);
             Scanner mov = new Scanner(System.in);
             String attack = mov.nextLine();
             if (attack.equalsIgnoreCase("block") || attack.equalsIgnoreCase("hit") || attack.equalsIgnoreCase("magic")) {
             } else {
                 attack = randommove[(int) (Math.random() * randommove.length)];
             }
             System.out.println("Lich use " + randommove[moves] + ".");
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
             System.out.println("Lich's health: " + mhealth + ", Lich's attack: " + mattack);
             System.out.println("Your health: " + x.gethealth() + ", Your armor: " + x.getarmor() + ", Your attack: " + x.getattack());
         }
         if(mhealth < 0)
         {
             System.out.println("You defeated the Lich.");
             System.out.println("Congratulation! You won!");
         }
         if(x.gethealth() < 0)
         {
             System.out.println("Game over! You have died.");
         }
         Runner.gameOff();
     }
}
