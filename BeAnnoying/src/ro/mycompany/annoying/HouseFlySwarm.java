package ro.mycompany.annoying;

import ro.mycompany.Player;

public class HouseFlySwarm extends HouseFly {//Open closed principle
    public HouseFlySwarm() {
        id = EAnnoyingThings.HouseFlySwarm;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println("Some random fly has appeared out of nowhere and tries to disturb "+target.getUsername()+"'s dinner.");
        System.out.println("Suddenly more of them appear and swarm the dinning room.");
        System.out.println(target.getUsername()+" starts to take care of this fly swarm for some minutes...");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 9.)");
        target.getHungerMeter().increaseHunger(9);
    }

    @Override
    public String toString() {
        return "House Fly Swarm";
    }
}
