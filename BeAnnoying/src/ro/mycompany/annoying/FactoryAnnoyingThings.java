package ro.mycompany.annoying;

import java.util.Random;

public class FactoryAnnoyingThings {
    private static Random rnd = new Random();
    public static IAnnoying getAnnoyingThing(EAnnoyingThings id){//Dependency injection principle
        IAnnoying annoyingThing = null;

        if(id == EAnnoyingThings.Dog){
            return new Dog();
        }
        if(id == EAnnoyingThings.HouseFly){
            return new HouseFly();
        }if(id == EAnnoyingThings.HouseFlySwarm){
            return new HouseFlySwarm();
        }if(id == EAnnoyingThings.NeighbourKid){
            return new NeighbourKid();
        }if(id == EAnnoyingThings.Neighbour){
            return new Neighbour();
        }if(id == EAnnoyingThings.Telemarketer){
            return new Telemarketer();
        }if(id == EAnnoyingThings.WeirdSound){
            return new WeirdSound();
        }

        return annoyingThing;
    }
}
