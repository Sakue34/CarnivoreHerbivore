package pl.edu.pwr.carnivoreherbivore;

public class MapCreator {

    private void createPlants(SimulationMap simulationMap, int numberOfPlants, float maxX, float maxY) {
        for (int i = 0; i < numberOfPlants; i++) {
            Position position = Position.getRandomPosition(maxX, maxY);
            simulationMap.AddPawn(new Plant(), position);
        }
    }

    private void createHerbivores(SimulationMap simulationMap, int numberOfHerbivores, float maxX, float maxY) {
        for (int i = 0; i < numberOfHerbivores; i++) {
            Position position = Position.getRandomPosition(maxX, maxY);
            simulationMap.AddPawn(new Herbivore(), position);
        }
    }

    private void createCarnivores(SimulationMap simulationMap, int numberOfCarnivores, float maxX, float maxY) {
        for (int i = 0; i < numberOfCarnivores; i++) {
            Position position = Position.getRandomPosition(maxX, maxY);
            simulationMap.AddPawn(new Carnivore(), position);
        }
    }

    public SimulationMap Create(SimulationParameters simulationParameters) {
        SimulationMap simulationMap = new SimulationMap();
        float maxX = simulationParameters.mapWidth;
        float maxY = simulationParameters.mapHeight;
        createPlants(simulationMap, simulationParameters.startingNumberOfPlants, maxX, maxY);
        createHerbivores(simulationMap, simulationParameters.startingNumberOfHerbivores, maxX, maxY);
        createCarnivores(simulationMap, simulationParameters.startingNumberOfCarnivores, maxX, maxY);
        return simulationMap;
    }
}
