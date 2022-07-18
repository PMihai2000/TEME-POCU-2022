package ro.mycompany;

import ro.mycompany.annoying.HungerSystem;

public class Player {
    private final String username;

    private final HungerSystem hungerMeter;

    public String getUsername() {
        return username;
    }


    public Player(String username, int hungerPoints) {
        this.username = username;
        hungerMeter = new HungerSystem(hungerPoints);
    }

    @Override
    public String toString() {
        return username+", "+hungerMeter.getHungerPoints()+" hunger points.";
    }

    public void eat(int value){
        System.out.println("Nothing happens...");
        System.out.println(username+" eats something...");
        System.out.println("("+username+"'s Hunger Meter decreases by "+value+".)");
        hungerMeter.decreaseHunger(value);
    }

    public int getHungerPoints(){
        return hungerMeter.getHungerPoints();
    }

    public void increaseHunger(int value){
        hungerMeter.increaseHunger(value);
    }

    public void  decreaseHunger(int value){
        hungerMeter.decreaseHunger(value);
    }

    public boolean isHungry(){
        return hungerMeter.isHungry();
    }
}
