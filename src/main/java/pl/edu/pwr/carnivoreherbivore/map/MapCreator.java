package pl.edu.pwr.carnivoreherbivore.map;

import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;
import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;
import pl.edu.pwr.carnivoreherbivore.pawn.Carnivore;
import pl.edu.pwr.carnivoreherbivore.pawn.Herbivore;
import pl.edu.pwr.carnivoreherbivore.pawn.Plant;

import java.util.*;

/**
 * Klasa tworząca mapę na której odbywa się symulacja i zapełniająca ją początkową liczbą pionków.
 * @see pl.edu.pwr.carnivoreherbivore.simulation.SimulationCreator
 */
public final class MapCreator {
    private void createPlants(List<Pawn> pawns, Map<Pawn, Position> pawnsPosition, SimulationParameters simulationParameters) {
        for (int i = 0; i < simulationParameters.startingNumberOfPlants; i++) {
            Position position = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            Pawn pawn = new Plant(simulationParameters);
            pawns.add(pawn);
            pawnsPosition.put(pawn, position);
        }
    }

    private void createHerbivores(List<Pawn> pawns, Map<Pawn, Position> pawnsPosition, SimulationParameters simulationParameters) {
        for (int i = 0; i < simulationParameters.startingNumberOfHerbivores; i++) {
            Position position = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            Pawn pawn = new Herbivore(simulationParameters);
            pawns.add(pawn);
            pawnsPosition.put(pawn, position);
        }
    }

    private void createCarnivores(List<Pawn> pawns, Map<Pawn, Position> pawnsPosition, SimulationParameters simulationParameters) {
        for (int i = 0; i < simulationParameters.startingNumberOfCarnivores; i++) {
            Position position = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            Pawn pawn = new Carnivore(simulationParameters);
            pawns.add(pawn);
            pawnsPosition.put(pawn, position);
        }
    }

    public SimulationMap create(SimulationParameters simulationParameters) {
        List<Pawn> pawns = Collections.synchronizedList(new ArrayList<>());
        Map<Pawn, Position> pawnsPosition = Collections.synchronizedMap(new HashMap<>());

        createPlants(pawns, pawnsPosition, simulationParameters);
        createHerbivores(pawns, pawnsPosition, simulationParameters);
        createCarnivores(pawns, pawnsPosition, simulationParameters);

        return new SimulationMap(pawns, pawnsPosition);
    }
}
