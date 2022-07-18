package ro.mycompany.annoying;

import ro.mycompany.Player;

public class Dog extends AnnoyingThing implements IAnnoying{
    public Dog() {
        id = EAnnoyingThings.Dog;
    }

    @Override
    public void beAnnoying(Player target) {
        System.out.println("Some random dogs had start to bark at a cat.");
        System.out.println(target.getUsername()+" goes out to stop them...");
        System.out.println(target.getUsername()+" got more hungry...");
        System.out.println("("+target.getUsername()+"'s Hunger Meter increases by 4.)");
        target.getHungerMeter().increaseHunger(4);
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
