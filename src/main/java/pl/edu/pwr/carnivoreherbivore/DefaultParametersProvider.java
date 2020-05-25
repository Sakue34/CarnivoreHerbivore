package pl.edu.pwr.carnivoreherbivore;

//Debug class that returns default simulation parameters
public class DefaultParametersProvider implements ConfigProvider{
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
        return sP;
    }
}
