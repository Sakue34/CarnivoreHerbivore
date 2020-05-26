package pl.edu.pwr.carnivoreherbivore.config;

import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

//Debug class that returns default simulation parameters
public final class DefaultParametersProvider implements ConfigProvider {
    @Override
    public SimulationParameters get() {
        SimulationParameters sP = new SimulationParameters();
        sP.mapHeight = 800;
        sP.mapWidth = 1024;
        sP.speedOfSimulationMultiplier = 1.0F;
        sP.startingNumberOfPlants = 50;
        sP.startingNumberOfHerbivores = 20;
        sP.startingNumberOfCarnivores = 4;
        sP.herbivoreSpeed = 50;
        sP.carnivoreSpeed = 60;
        sP.plantNutritionalValue = 20;
        sP.herbivoreStartingEnergy = 50;
        sP.carnivoreStartingEnergy = 50;
        sP.herbivoreEnergyConsumptionPerSecond = 4;
        sP.carnivoreEnergyConsumptionPerSecond = 6;
        sP.plantRadius = 3;
        sP.herbivoreRadius = 5;
        sP.carnivoreRadius = 8;
        sP.herbivoreSightRange = 300;
        sP.carnivoreSightRange = 300;
        sP.baseHerbivoreNutritionalValue = 0;
        sP.numberOfPawnsToEndSimulation = 0;
        sP.timeToSetNewRandomHerbivoreWanderDirection = 4.0F;
        sP.timeToSetNewRandomCarnivoreWanderDirection = 4.0F;
        sP.colourStringOfPlant = "0x11EE22";
        sP.colourStringOfHerbivore = "0x77BA66";
        sP.colourStringOfCarnivore = "0xFF1133";
        sP.useGUI = true;
        sP.timeBetweenProgressOutputInTerminal = 1.0F;
        return sP;
    }
}
