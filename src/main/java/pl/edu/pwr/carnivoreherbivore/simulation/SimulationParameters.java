package pl.edu.pwr.carnivoreherbivore.simulation;

public final class SimulationParameters {
    public int mapWidth;
    public int mapHeight;
    public float speedOfSimulationMultiplier;
    public int startingNumberOfPlants;
    public int startingNumberOfHerbivores;
    public int startingNumberOfCarnivores;
    public float herbivoreSpeed;
    public float carnivoreSpeed;
    public float plantNutritionalValue;
    public float herbivoreStartingEnergy;
    public float carnivoreStartingEnergy;
    public float herbivoreEnergyConsumptionPerSecond;
    public float carnivoreEnergyConsumptionPerSecond;
    public int plantRadius;
    public int herbivoreRadius;
    public int carnivoreRadius;
    public float herbivoreSightRange;
    public float carnivoreSightRange;
    public float baseHerbivoreNutritionalValue;
    public float timeToSetNewRandomHerbivoreWanderDirection;
    public float timeToSetNewRandomCarnivoreWanderDirection;
    public String colourStringOfPlant;
    public String colourStringOfHerbivore;
    public String colourStringOfCarnivore;
    public boolean useGUI;
    public float timeBetweenProgressOutputInTerminal;
    public int numberOfPawnsToEndSimulation;
    public boolean endSimulationWhenNoHerbivoresLeft;
    public boolean endSimulationWhenNoCarnivoresLeft;
    public float collisionRangeMultiplierOfSumOfRadii;
}
