import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Race {
    private int raceLength;
    private List<Horse> lanes;

    /**
     * Constructor to create a race with variable number of lanes
     *
     * @param distance  the length of the race
     * @param numLanes  how many horses can race
     */
    public Race(int distance, int numLanes) {
        raceLength = distance;
        lanes = new ArrayList<>(numLanes);

        // Initialize all lanes as empty (null)
        for (int i = 0; i < numLanes; i++) {
            lanes.add(null);
        }
    }

    /**
     * Add a horse to a specified lane
     *
     * @param theHorse     the horse object
     * @param laneNumber   the lane index (1-based)
     */
    public void addHorse(Horse theHorse, int laneNumber) {
        int index = laneNumber - 1;

        if (index >= 0 && index < lanes.size()) {
            lanes.set(index, theHorse);
        } else {
            System.out.println("Cannot add horse to lane " + laneNumber + " — invalid lane.");
        }
    }

    /**
     * Start the race simulation
     */
    public void startRace() {
        boolean anyHorsePresent = false;
        for (Horse horse : lanes) {
            if (horse != null) {
                horse.goBackToStart();
                anyHorsePresent = true;
            }
        }
    
        if (!anyHorsePresent) {
            System.out.println("🚫 No horses in the race. Add at least one horse.");
            return;
        }
    
        boolean finished = false;
        Horse winner = null;
    
        while (!finished) {
            for (Horse horse : lanes) {
                if (horse != null) {
                    moveHorse(horse);
                }
            }
    
            printRace();
    
            for (Horse horse : lanes) {
                if (horse != null && raceWonBy(horse)) {
                    winner = horse;
                    finished = true;
                    break;
                }
            }
    
            if (!finished && allHorsesFallen()) {
                System.out.println("\n☠️ All horses have fallen! The race ends with no winner.");
                return;
            }
    
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {}
        }
    
        if (winner != null) {
            winner.setConfidence(winner.getConfidence() + 0.1); // Increase confidence on win
            printRace();
            System.out.println("\n🏁 The winner is: " + winner.getName() + "!");
        }
    }

    private boolean allHorsesFallen() {
        boolean foundHorse = false;
        for (Horse horse : lanes) {
            if (horse != null) {
                foundHorse = true;
                if (!horse.hasFallen()) {
                    return false;
                }
            }
        }
        return foundHorse; // only true if there were horses and all are fallen
    }    

    private void moveHorse(Horse horse) {
        if (!horse.hasFallen()) {
            if (Math.random() < horse.getConfidence()) {
                horse.moveForward();
            }

            if (Math.random() < (0.1 * horse.getConfidence() * horse.getConfidence())) {
                horse.fall();
                horse.setConfidence(horse.getConfidence() - 0.1); // Decrease confidence on fall
            }
        }
    }

    private boolean raceWonBy(Horse horse) {
        return horse.getDistanceTravelled() >= raceLength;
    }

    private void printRace() {
        System.out.print('\u000C'); // Clear terminal
        multiplePrint('=', raceLength + 3);
        System.out.println();
    
        for (Horse horse : lanes) {
            if (horse != null) {
                printLane(horse);
            } else {
                System.out.println("|" + " ".repeat(raceLength) + " |  [Empty Lane]");
            }
        }
    
        multiplePrint('=', raceLength + 3);
        System.out.println();
    }
    
    private void printLane(Horse horse) {
        int spacesBefore = horse.getDistanceTravelled();
        int spacesAfter = raceLength - horse.getDistanceTravelled();
        if (spacesAfter < 0) spacesAfter = 0;
    
        // Start of the lane
        System.out.print('|');
    
        // Spaces before the horse
        multiplePrint(' ', spacesBefore);
    
        // Horse symbol or fallen mark
        if (horse.hasFallen()) {
            System.out.print('X'); // Fallen mark
        } else {
            System.out.print(horse.getSymbol());
        }
    
        // Spaces after the horse
        multiplePrint(' ', spacesAfter);
    
        // End of the lane
        System.out.print('|');
    
        // Display horse name and confidence
        String name = horse.getName();
        double confidence = horse.getConfidence();
    
        System.out.println("  " + name + " | Confidence: " + String.format("%.2f", confidence));
    }

    private void multiplePrint(char c, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(c);
        }
    }
}
