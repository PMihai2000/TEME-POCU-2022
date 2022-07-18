package ro.mycompany.annoying;

import ro.mycompany.Player;

public class Telemarketer extends AnnoyingThing implements IAnnoying{
    public Telemarketer() {
        id = EAnnoyingThings.Telemarketer;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println(target.getUsername()+" is eating and suddenly hears his phone ringing.");
        System.out.println(target.getUsername()+" doesn't know that phone number but still responds to it...");
        System.out.println("Responding to that phone call "+target.getUsername()+" get more annoyed with some telemarketer" +
                "who wants to sell his x-ray glasses for an expensive prince.");
        System.out.println(target.getUsername()+" gets somehow out of this call and gets back to dinner.");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 5.)");
        target.getHungerMeter().increaseHunger(5);
    }

    @Override
    public String toString() {
        return "Telemarketer";
    }
}
