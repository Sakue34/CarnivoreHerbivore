package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.pawn.*;

/**
 * Pomocniczna klasa tworzona przez klasy wyświetlające postęp po spełnieniu
 * warunków zakończenia symulacji.
 */
public class SimulationResults {
    private int numberOfCarnivoresLeft = 0;
    private int numberOfHerbivoresLeft = 0;
    private int numberOfPlantsLeft = 0;
    private int numberOfPawnsLeft = 0;

    public SimulationResults(SimulationMap simulationMap) {
        for(Pawn pawn : simulationMap.getPawns()) {
            if (pawn instanceof Plant) {
                numberOfPlantsLeft++;
            }
            else if (pawn instanceof Herbivore) {
                numberOfHerbivoresLeft++;
            }
            else if (pawn instanceof Carnivore) {
                numberOfCarnivoresLeft++;
            }
            numberOfPawnsLeft++;
        }
    }

    public int getNumberOfPawnsLeft() {
        return numberOfPawnsLeft;
    }

    public int getNumberOfCarnivoresLeft() {
        return numberOfCarnivoresLeft;
    }

    public int getNumberOfHerbivoresLeft() {
        return numberOfHerbivoresLeft;
    }

    public int getNumberOfPlantsLeft() {
        return numberOfPlantsLeft;
    }
}
