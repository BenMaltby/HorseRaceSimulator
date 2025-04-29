import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // function testing
        System.out.println("Running basic tests...");

        Horse testHorse = new Horse('♘', "TEST", 0.5);
        testHorse.moveForward();
        System.out.println("Distance after moveForward(): " + testHorse.getDistanceTravelled());

        testHorse.fall();
        System.out.println("Has fallen: " + testHorse.hasFallen());
        System.out.println("Confidence after fall: " + testHorse.getConfidence());

        testHorse.goBackToStart();
        System.out.println("Distance after reset: " + testHorse.getDistanceTravelled());

        testHorse.setConfidence(0.9);
        System.out.println("Confidence after win: " + testHorse.getConfidence());

        System.out.println("\n--- TESTS COMPLETE ---\n");

        // Actual race for the user
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Horse Racing Simulator!");
        System.out.print("Enter race length: ");
        int raceLength = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter number of lanes: ");
        int numLanes = scan.nextInt();
        scan.nextLine();

        Race race = new Race(raceLength, numLanes);

        for (int i = 1; i <= numLanes; i++) {
            System.out.println("\n--- Setup for Lane " + i + " ---");
            System.out.print("Enter horse name (or leave empty to skip this lane): ");
            String name = scan.nextLine().trim();

            if (name.isEmpty()) {
                race.addHorse(null, i);
                continue;
            }

            System.out.print("Enter a single character to represent the horse (symbol): ");
            char symbol = scan.nextLine().charAt(0);

            System.out.print("Enter confidence level (0.0 to 1.0): ");
            double confidence = scan.nextDouble();
            scan.nextLine();

            Horse horse = new Horse(symbol, name, confidence);
            race.addHorse(horse, i);
        }

        System.out.println("\nStarting race...");
        race.startRace();

        scan.close();
    }
}