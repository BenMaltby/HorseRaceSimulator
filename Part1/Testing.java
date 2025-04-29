public class Testing {
    public static void main(String[] args) {
        // Create a Horse object
        Horse horse1 = new Horse('A', "Thunder", 0.8);
        
        // Test the getName method
        System.out.println("Horse Name: " + horse1.getName()); // Expected: Thunder
        
        // Test the getSymbol method
        System.out.println("Horse Symbol: " + horse1.getSymbol()); // Expected: A
        
        // Test the getDistanceTravelled method
        System.out.println("Distance Travelled: " + horse1.getDistanceTravelled()); // Expected: 0
        
        // Test the hasFallen method
        System.out.println("Has Fallen: " + horse1.hasFallen()); // Expected: false
        
        // Move the horse1 forward and test again
        horse1.moveForward();
        System.out.println("Distance Travelled after moving forward: " + horse1.getDistanceTravelled()); // Expected: 1
        
        // Test the fall method
        horse1.fall();
        System.out.println("Has Fallen after falling: " + horse1.hasFallen()); // Expected: true
        
        // Test the goBackToStart method
        horse1.goBackToStart();
        System.out.println("Distance Travelled after going back to start: " + horse1.getDistanceTravelled()); // Expected: 0

        Race race = new Race(10, 4); // 4-lane race

        race.addHorse(new Horse('♞', "BLAZE", 0.9), 1);
        race.addHorse(new Horse('♘', "STORM", 0.85), 2);
        race.addHorse(new Horse('⍟', "THUNDER", 0.8), 3);
        race.addHorse(new Horse('Δ', "COMET", 0.75), 4);

        race.startRace();
    }
}
