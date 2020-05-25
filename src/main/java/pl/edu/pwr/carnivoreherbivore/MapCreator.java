package pl.edu.pwr.carnivoreherbivore;

public class MapCreator {

    private void createPlants(SimulationMap simulationMap, SimulationParameters simulationParameters) {
        for (int i = 0; i < simulationParameters.startingNumberOfPlants; i++) {
            Position position = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            simulationMap.addPawn(new Plant(simulationParameters), position);
        }
    }

    private void createHerbivores(SimulationMap simulationMap, SimulationParameters simulationParameters) {
        for (int i = 0; i < simulationParameters.startingNumberOfHerbivores; i++) {
            Position position = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            simulationMap.addPawn(new Herbivore(simulationParameters), position);
        }
    }

    private void createCarnivores(SimulationMap simulationMap, SimulationParameters simulationParameters) {
        for (int i = 0; i < simulationParameters.startingNumberOfCarnivores; i++) {
            Position position = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            simulationMap.addPawn(new Carnivore(simulationParameters), position);
        }
    }

    public SimulationMap create(SimulationParameters simulationParameters) {
        SimulationMap simulationMap = new SimulationMap();
        createPlants(simulationMap, simulationParameters);
        createHerbivores(simulationMap, simulationParameters);
        createCarnivores(simulationMap, simulationParameters);
        return simulationMap;
    }
}
