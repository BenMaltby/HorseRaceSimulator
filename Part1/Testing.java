import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        // === Automated Tests ===
        System.out.println("Running basic tests...");

        Horse testHorse = new Horse('♘', "TESTER", 0.5);
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

        // === User-Configured Race ===
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Horse Racing Simulator!");
        System.out.print("Enter race length: ");
        int raceLength = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter number of lanes: ");
        int numberOfLanes = scanner.nextInt();
        scanner.nextLine();

        Race race = new Race(raceLength, numberOfLanes);

        for (int i = 1; i <= numberOfLanes; i++) {
            System.out.println("\n--- Setup for Lane " + i + " ---");
            System.out.print("Enter horse name (or leave empty to skip this lane): ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                race.addHorse(null, i);
                continue;
            }

            System.out.print("Enter a single character to represent the horse (symbol): ");
            char symbol = scanner.nextLine().charAt(0);

            System.out.print("Enter confidence level (0.0 to 1.0): ");
            double confidence = scanner.nextDouble();
            scanner.nextLine();

            Horse horse = new Horse(symbol, name, confidence);
            race.addHorse(horse, i);
        }

        System.out.println("\nStarting race...");
        race.startRace();

        scanner.close();
    }
}