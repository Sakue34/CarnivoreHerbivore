package pl.edu.pwr.carnivoreherbivore.config;

import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

public final class DefaultParametersProvider implements ConfigProvider {
    @Override
    public SimulationParameters get() {
        SimulationParameters sP = new SimulationParameters();
        sP.mapHeight = 800;
        sP.mapWidth = 1024;
        sP.speedOfSimulationMultiplier = 1.0F;
        sP.startingNumberOfPlants = 60;
        sP.startingNumberOfHerbivores = 10;
        sP.startingNumberOfCarnivores = 4;
        sP.herbivoreSpeed = 50;
        sP.carnivoreSpeed = 60;
        sP.plantNutritionalValue = 20;
        sP.herbivoreStartingEnergy = 50;
        sP.carnivoreStartingEnergy = 50;
        sP.herbivoreEnergyConsumptionPerSecond = 4;
        sP.carnivoreEnergyConsumptionPerSecond = 6;
        sP.plantRadius = 3;
        sP.herbivoreRadius = 6;
        sP.carnivoreRadius = 8;
        sP.herbivoreSightRange = 100;
        sP.carnivoreSightRange = 100;
        sP.baseHerbivoreNutritionalValue = 0;
        sP.timeToSetNewRandomHerbivoreWanderDirection = 4.0F;
        sP.timeToSetNewRandomCarnivoreWanderDirection = 4.0F;
        sP.colourStringOfPlant = "0x7bf542";
        sP.colourStringOfHerbivore = "0x5cc432";
        sP.colourStringOfCarnivore = "0xc70000";
        sP.useGUI = false;
        sP.timeBetweenProgressOutputInTerminal = 1.0F;
        sP.numberOfPawnsToEndSimulation = 20;
        sP.endSimulationWhenNoHerbivoresLeft = true;
        sP.endSimulationWhenNoCarnivoresLeft = true;
        sP.collisionRangeMultiplierOfSumOfRadii = 0.5F;
        return sP;
    }
}
