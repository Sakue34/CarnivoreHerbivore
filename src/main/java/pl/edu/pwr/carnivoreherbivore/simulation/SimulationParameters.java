package pl.edu.pwr.carnivoreherbivore.simulation;

/**
 * Klasa przechowująca parametry symulacji.
 */
public final class SimulationParameters {
    public final int mapWidth;
    public final int mapHeight;
    public final float speedOfSimulationMultiplier;
    public final int startingNumberOfPlants;
    public final int startingNumberOfHerbivores;
    public final int startingNumberOfCarnivores;
    public final float herbivoreSpeed;
    public final float carnivoreSpeed;
    public final float plantNutritionalValue;
    public final float herbivoreStartingEnergy;
    public final float carnivoreStartingEnergy;
    public final float herbivoreEnergyConsumptionPerSecond;
    public final float carnivoreEnergyConsumptionPerSecond;
    public final int plantRadius;
    public final int herbivoreRadius;
    public final int carnivoreRadius;
    public final float herbivoreSightRange;
    public final float carnivoreSightRange;
    public final float baseHerbivoreNutritionalValue;
    public final float timeToSetNewRandomHerbivoreWanderDirection;
    public final float timeToSetNewRandomCarnivoreWanderDirection;
    public final String colourStringOfPlant;
    public final String colourStringOfHerbivore;
    public final String colourStringOfCarnivore;
    public final boolean useGUI;
    public final float timeBetweenProgressOutputInTerminal;
    public final int numberOfPawnsToEndSimulation;
    public final boolean endSimulationWhenNoHerbivoresLeft;
    public final boolean endSimulationWhenNoCarnivoresLeft;
    public final float collisionRangeMultiplierOfSumOfRadii;

    public SimulationParameters(int mapWidth, int mapHeight, float speedOfSimulationMultiplier, int startingNumberOfPlants, int startingNumberOfHerbivores, int startingNumberOfCarnivores, float herbivoreSpeed, float carnivoreSpeed, float plantNutritionalValue, float herbivoreStartingEnergy, float carnivoreStartingEnergy, float herbivoreEnergyConsumptionPerSecond, float carnivoreEnergyConsumptionPerSecond, int plantRadius, int herbivoreRadius, int carnivoreRadius, float herbivoreSightRange, float carnivoreSightRange, float baseHerbivoreNutritionalValue, float timeToSetNewRandomHerbivoreWanderDirection, float timeToSetNewRandomCarnivoreWanderDirection, String colourStringOfPlant, String colourStringOfHerbivore, String colourStringOfCarnivore, boolean useGUI, float timeBetweenProgressOutputInTerminal, int numberOfPawnsToEndSimulation, boolean endSimulationWhenNoHerbivoresLeft, boolean endSimulationWhenNoCarnivoresLeft, float collisionRangeMultiplierOfSumOfRadii) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.speedOfSimulationMultiplier = speedOfSimulationMultiplier;
        this.startingNumberOfPlants = startingNumberOfPlants;
        this.startingNumberOfHerbivores = startingNumberOfHerbivores;
        this.startingNumberOfCarnivores = startingNumberOfCarnivores;
        this.herbivoreSpeed = herbivoreSpeed;
        this.carnivoreSpeed = carnivoreSpeed;
        this.plantNutritionalValue = plantNutritionalValue;
        this.herbivoreStartingEnergy = herbivoreStartingEnergy;
        this.carnivoreStartingEnergy = carnivoreStartingEnergy;
        this.herbivoreEnergyConsumptionPerSecond = herbivoreEnergyConsumptionPerSecond;
        this.carnivoreEnergyConsumptionPerSecond = carnivoreEnergyConsumptionPerSecond;
        this.plantRadius = plantRadius;
        this.herbivoreRadius = herbivoreRadius;
        this.carnivoreRadius = carnivoreRadius;
        this.herbivoreSightRange = herbivoreSightRange;
        this.carnivoreSightRange = carnivoreSightRange;
        this.baseHerbivoreNutritionalValue = baseHerbivoreNutritionalValue;
        this.timeToSetNewRandomHerbivoreWanderDirection = timeToSetNewRandomHerbivoreWanderDirection;
        this.timeToSetNewRandomCarnivoreWanderDirection = timeToSetNewRandomCarnivoreWanderDirection;
        this.colourStringOfPlant = colourStringOfPlant;
        this.colourStringOfHerbivore = colourStringOfHerbivore;
        this.colourStringOfCarnivore = colourStringOfCarnivore;
        this.useGUI = useGUI;
        this.timeBetweenProgressOutputInTerminal = timeBetweenProgressOutputInTerminal;
        this.numberOfPawnsToEndSimulation = numberOfPawnsToEndSimulation;
        this.endSimulationWhenNoHerbivoresLeft = endSimulationWhenNoHerbivoresLeft;
        this.endSimulationWhenNoCarnivoresLeft = endSimulationWhenNoCarnivoresLeft;
        this.collisionRangeMultiplierOfSumOfRadii = collisionRangeMultiplierOfSumOfRadii;
    }
}
