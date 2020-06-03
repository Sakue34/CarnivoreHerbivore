package pl.edu.pwr.carnivoreherbivore.config;

import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

/**
 * Klasa dostarczająca początkowe parametry symulacji, używając do tego domyślnych wartości.
 * Używana gdy z różnych przyczyn nie udało się odczytać pliku konfiguracyjnego z dysku.
 * @see pl.edu.pwr.carnivoreherbivore.App
 */
public final class DefaultParametersProvider implements ConfigProvider {
    @Override
    public SimulationParameters get() {
        int mapHeight = 800;
        int mapWidth = 1024;
        float speedOfSimulationMultiplier = 1.0F;
        int startingNumberOfPlants = 60;
        int startingNumberOfHerbivores = 10;
        int startingNumberOfCarnivores = 4;
        float herbivoreSpeed = 50;
        float carnivoreSpeed = 60;
        float plantNutritionalValue = 20;
        float herbivoreStartingEnergy = 50;
        float carnivoreStartingEnergy = 50;
        float herbivoreEnergyConsumptionPerSecond = 4;
        float carnivoreEnergyConsumptionPerSecond = 6;
        int plantRadius = 3;
        int herbivoreRadius = 6;
        int carnivoreRadius = 8;
        float herbivoreSightRange = 100;
        float carnivoreSightRange = 100;
        float baseHerbivoreNutritionalValue = 0;
        float timeToSetNewRandomHerbivoreWanderDirection = 4.0F;
        float timeToSetNewRandomCarnivoreWanderDirection = 4.0F;
        String colourStringOfPlant = "0x7bf542";
        String colourStringOfHerbivore = "0x5cc432";
        String colourStringOfCarnivore = "0xc70000";
        boolean useGUI = true;
        float timeBetweenProgressOutputInTerminal = 1.0F;
        int numberOfPawnsToEndSimulation = 10;
        boolean endSimulationWhenNoHerbivoresLeft = true;
        boolean endSimulationWhenNoCarnivoresLeft = false;
        float collisionRangeMultiplierOfSumOfRadii = 0.5F;

        return new SimulationParameters(mapWidth, mapHeight, speedOfSimulationMultiplier, startingNumberOfPlants, startingNumberOfHerbivores, startingNumberOfCarnivores, herbivoreSpeed, carnivoreSpeed, plantNutritionalValue, herbivoreStartingEnergy, carnivoreStartingEnergy, herbivoreEnergyConsumptionPerSecond, carnivoreEnergyConsumptionPerSecond, plantRadius, herbivoreRadius, carnivoreRadius, herbivoreSightRange, carnivoreSightRange, baseHerbivoreNutritionalValue, timeToSetNewRandomHerbivoreWanderDirection, timeToSetNewRandomCarnivoreWanderDirection, colourStringOfPlant, colourStringOfHerbivore, colourStringOfCarnivore, useGUI, timeBetweenProgressOutputInTerminal, numberOfPawnsToEndSimulation, endSimulationWhenNoHerbivoresLeft, endSimulationWhenNoCarnivoresLeft, collisionRangeMultiplierOfSumOfRadii);
    }
}
