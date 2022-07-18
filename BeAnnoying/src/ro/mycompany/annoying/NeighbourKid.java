package ro.mycompany.annoying;

import ro.mycompany.Player;

public class NeighbourKid extends Neighbour{//Open closed principle
    public NeighbourKid() {
        id = EAnnoyingThings.NeighbourKid;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println(target.getUsername()+" is eating and suddenly hears someone screaming at his door.");
        System.out.println(target.getUsername()+" checks out who's there and finds out that's the neighbour kid" +
                " who lost his ball on "+target.getUsername()+"'s house roof...");
        System.out.println(target.getUsername()+" goes to take down that ball from his roof.");
        System.out.println("After some time "+target.getUsername()+" went back to the kid with his ball but he ran away...");
        System.out.println(target.getUsername()+" gets more annoyed with that kid.");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 4.)");
        target.getHungerMeter().increaseHunger(4);
    }

    @Override
    public String toString() {
        return "Neightbour Kid";
    }
}
