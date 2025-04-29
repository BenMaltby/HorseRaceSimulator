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
        // Validate that all lanes have horses
        for (int i = 0; i < lanes.size(); i++) {
            if (lanes.get(i) == null) {
                System.out.println("Lane " + (i + 1) + " is empty. All lanes must have horses.");
                return;
            }
        }

        // Reset all horses
        for (Horse horse : lanes) {
            horse.goBackToStart();
        }

        boolean finished = false;
        Horse winner = null;

        while (!finished) {
            for (Horse horse : lanes) {
                moveHorse(horse);
            }

            printRace();

            for (Horse horse : lanes) {
                if (raceWonBy(horse)) {
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
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {
            }
        }

        if (winner != null) {
            System.out.println("\n🏁 The winner is: " + winner.getName() + "!");
        }
    }

    private boolean allHorsesFallen() {
        for (Horse horse : lanes) {
            if (!horse.hasFallen()) {
                return false;
            }
        }
        return true;
    }

    private void moveHorse(Horse horse) {
        if (!horse.hasFallen()) {
            if (Math.random() < horse.getConfidence()) {
                horse.moveForward();
            }

            if (Math.random() < (0.1 * horse.getConfidence() * horse.getConfidence())) {
                horse.fall();
            }
        }
    }

    private boolean raceWonBy(Horse horse) {
        return horse.getDistanceTravelled() >= raceLength;
    }

    private void printRace() {
        System.out.print('\u000C'); // clear terminal
        multiplePrint('=', raceLength + 3);
        System.out.println();

        for (Horse horse : lanes) {
            printLane(horse);
            System.out.println();
        }

        multiplePrint('=', raceLength + 3);
        System.out.println();
    }

    private void printLane(Horse horse) {
        int spacesBefore = horse.getDistanceTravelled();
        int spacesAfter = raceLength - horse.getDistanceTravelled();
        if (spacesAfter < 0) spacesAfter = 0;

        System.out.print('|');
        multiplePrint(' ', spacesBefore);

        if (horse.hasFallen()) {
            System.out.print('X'); // fallen symbol
        } else {
            System.out.print(horse.getSymbol());
        }

        multiplePrint(' ', spacesAfter);
        System.out.print('|');
    }

    private void multiplePrint(char c, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(c);
        }
    }
}
