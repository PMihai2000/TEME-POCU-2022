package ro.mycompany.annoying;

public class HungerSystem {
    private static final int MIN_HUNGER_VALUE = 1;
    private static final int MAX_HUNGER_VALUE = 100;

    private int hungerPoints;

    public HungerSystem(int hungerPoints) {
        setHungerPoints(hungerPoints);

    }

    public int getHungerPoints() {
        return hungerPoints;
    }

    public void setHungerPoints(int hungerMeter) {
        this.hungerPoints = hungerMeter>=MIN_HUNGER_VALUE && hungerMeter <= MAX_HUNGER_VALUE?hungerMeter:
                hungerMeter<MIN_HUNGER_VALUE?MIN_HUNGER_VALUE:MAX_HUNGER_VALUE;
    }

    public void increaseHunger(int value){
        hungerPoints+= value;
    }

    public void  decreaseHunger(int value){
        hungerPoints-= value;
    }

    public boolean isHungry(){
        return hungerPoints >= MIN_HUNGER_VALUE;
    }
}
