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

        Horse horse2 = new Horse('B', "Lightning", 0.6);
        Horse horse3 = new Horse('C', "Blaze", 0.9);

        Race race = new Race(10);
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.startRace();
    }
}
