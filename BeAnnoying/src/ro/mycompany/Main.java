package ro.mycompany;

import ro.mycompany.annoying.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void StartSimulation(){
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        int countEvents = 1;
        Player player = null;
        IAnnoying annoyingThing;


        System.out.println("========== Welcome to ==========");
        System.out.println(" ======= 'Be Annoying!' =======");
        System.out.println();
        System.out.println("Press ENTER to start the simulation or pass through text...");
        System.out.println();
        try {
            System.in.read();
            System.out.println("I guess this is another normal day...");
            System.in.read();
            System.out.println("Working on my projects, playing some video games ");
            System.out.println("and now I'm gonna eat something delicious.");
            System.in.read();
            System.out.println("I hope nothing annoys me...");
            System.in.read();
            System.out.println("(How shall we call you?)");

            String username;

            do {
                System.out.print("Username: ");
                username = scanner.next().strip();
            } while (username.length() == 0);

            player = new Player(username, rnd.nextInt(40, 70));

            System.out.printf("(Right now my Hunger Meter says that you have %d mood points.)%n", player.getHungerPoints());
            System.out.println("(During your meal some annoying things will appear to disturb you.)");
            System.out.println("(So... try and resist until you finish your meal, reaching 0 hunger points.)");
            System.out.println("(Have fun!)\n");

            do{
                System.out.println("["+player+"]");
                System.out.println("===============================");

                int chanceAnnoyingEvent = rnd.nextInt(0,100);

                if(0<= chanceAnnoyingEvent && chanceAnnoyingEvent <20){
                    player.eat(rnd.nextInt(10,25));
                }else{
                    annoyingThing = FactoryAnnoyingThings.getAnnoyingThing(EAnnoyingThings.values()[rnd.nextInt(0,7)]);
                    annoyingThing.beAnnoying(player);
                }

                System.out.println("===============================");
                System.out.println();

                if(!player.isHungry() || countEvents>30){
                    break;
                }
                System.in.read();

                countEvents++;
            }while(true);

            if(player.getHungerPoints()<=0){
                System.out.println("(In the end, this dinner was great for "+player.getUsername()+".)");
            }else{
                System.out.println("(In the end, this dinner was nasty for "+player.getUsername()+"...)");
            }

            System.out.println("\n\nThank you for trying this app! :D");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        StartSimulation();
    }
}