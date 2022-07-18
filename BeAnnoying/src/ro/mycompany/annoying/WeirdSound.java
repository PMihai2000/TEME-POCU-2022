package ro.mycompany.annoying;

import ro.mycompany.Player;

public class WeirdSound extends AnnoyingThing implements IAnnoying{
    public WeirdSound() {
        id = EAnnoyingThings.WeirdSound;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println(target.getUsername()+" is eating and suddenly hears a strange sound.");
        System.out.println(target.getUsername()+" get off his chair and tries to find out the source of that sound.");
        System.out.println("This event takes some time but "+target.getUsername()+" doesn't find the source of that sound...");
        System.out.println(target.getUsername()+" gave up and goes back to dinner.");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 7.)");
        target.getHungerMeter().increaseHunger(5);
    }

    @Override
    public String toString() {
        return "WeirdSound";
    }
}
