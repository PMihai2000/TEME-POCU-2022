package ro.mycompany.annoying;

import ro.mycompany.Player;

public class HouseFly extends AnnoyingThing implements IAnnoying{
    public HouseFly() {
        id = EAnnoyingThings.HouseFly;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println("Some random fly has appeared out of nowhere and tries to disturb "+target.getUsername()+"'s dinner.");
        System.out.println(target.getUsername()+" has a great accuracy and slaps it at at a perfect moment.");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 2.)");
        target.getHungerMeter().increaseHunger(2);
    }

    @Override
    public String toString() {
        return "House Fly";
    }
}
