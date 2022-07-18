package ro.mycompany.annoying;

import ro.mycompany.Player;

public class Neighbour extends AnnoyingThing implements IAnnoying{
    public Neighbour() {
        id = EAnnoyingThings.Neighbour;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println(target.getUsername()+" is eating and suddenly hears someone at his door.");
        System.out.println(target.getUsername()+" checks out who's there and finds out that's his neighbour...");
        System.out.println("The neighbour was lonely by that time and decided to visit "+target.getUsername()+" to annoy him.");
        System.out.println("After 1 hour "+ target.getUsername()+"'s neighbour leaves him and goes back to dinner.");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 7.)");
        target.getHungerMeter().increaseHunger(7);
    }

    @Override
    public String toString() {
        return "Neighbour";
    }
}
