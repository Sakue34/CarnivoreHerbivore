package pl.edu.pwr.carnivoreherbivore.config;

import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Klasa dostarczająca początkowe parametry symulacji pobierając je z pliku na dysku.
 */
public class FileConfigProvider implements ConfigProvider {
    String configFilename;

    public FileConfigProvider(String filename) {
        configFilename = filename;
    }

    private boolean getBoolean(Properties appProperties, String value, String defaultValue) {
        return Boolean.parseBoolean(appProperties.getProperty(value, defaultValue));
    }

    private int getInt(Properties appProperties, String value, String defaultValue) {
        return Integer.parseInt(appProperties.getProperty(value, defaultValue));
    }

    private float getFloat(Properties appProperties, String value, String defaultValue) {
        return Float.parseFloat(appProperties.getProperty(value, defaultValue));
    }

    private String getString(Properties appProperties, String value, String defaultValue) {
        return appProperties.getProperty(value, defaultValue);
    }

    @Override
    public SimulationParameters get() {
        SimulationParameters sP = null;
        try {
            Properties appProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(configFilename);
            appProperties.load(fileInputStream);
            int mapHeight = getInt(appProperties, "mapHeight", "800");
            int mapWidth = getInt(appProperties, "mapWidth", "1024");
            float speedOfSimulationMultiplier = getFloat(appProperties, "speedOfSimulationMultiplier", "1.0");
            int startingNumberOfPlants = getInt(appProperties, "startingNumberOfPlants", "60");
            int startingNumberOfHerbivores = getInt(appProperties, "startingNumberOfHerbivores", "10");
            int startingNumberOfCarnivores = getInt(appProperties, "startingNumberOfCarnivores", "4");
            float herbivoreSpeed = getFloat(appProperties, "herbivoreSpeed", "50.0");
            float carnivoreSpeed = getFloat(appProperties, "carnivoreSpeed", "60.0");
            float plantNutritionalValue = getFloat(appProperties, "plantNutritionalValue", "20.0");
            float herbivoreStartingEnergy = getFloat(appProperties, "herbivoreStartingEnergy", "50.0");
            float carnivoreStartingEnergy = getFloat(appProperties, "carnivoreStartingEnergy", "50.0");
            float herbivoreEnergyConsumptionPerSecond = getFloat(appProperties, "herbivoreEnergyConsumptionPerSecond", "4.0");
            float carnivoreEnergyConsumptionPerSecond = getFloat(appProperties, "carnivoreEnergyConsumptionPerSecond", "6.0");
            int plantRadius = getInt(appProperties, "plantRadius", "3");
            int herbivoreRadius = getInt(appProperties, "herbivoreRadius", "6");
            int carnivoreRadius = getInt(appProperties, "carnivoreRadius", "8");
            float herbivoreSightRange = getFloat(appProperties, "herbivoreSightRange", "100.0");
            float carnivoreSightRange = getFloat(appProperties, "carnivoreSightRange", "100.0");
            float baseHerbivoreNutritionalValue = getFloat(appProperties, "baseHerbivoreNutritionalValue", "0.0");
            float timeToSetNewRandomHerbivoreWanderDirection = getFloat(appProperties, "timeToSetNewRandomHerbivoreWanderDirection", "4.0");
            float timeToSetNewRandomCarnivoreWanderDirection = getFloat(appProperties, "timeToSetNewRandomCarnivoreWanderDirection", "4.0");
            String colourStringOfPlant = getString(appProperties, "colourStringOfPlant", "0x7bf542");
            String colourStringOfHerbivore = getString(appProperties, "colourStringOfHerbivore", "0x5cc432");
            String colourStringOfCarnivore = getString(appProperties, "colourStringOfCarnivore", "0xc70000");
            boolean useGUI = getBoolean(appProperties, "useGUI", "true");
            float timeBetweenProgressOutputInTerminal = getFloat(appProperties, "timeBetweenProgressOutputInTerminal", "1.0");
            int numberOfPawnsToEndSimulation = getInt(appProperties, "numberOfPawnsToEndSimulation", "10");
            boolean endSimulationWhenNoHerbivoresLeft = getBoolean(appProperties, "endSimulationWhenNoHerbivoresLeft", "true");
            boolean endSimulationWhenNoCarnivoresLeft = getBoolean(appProperties, "endSimulationWhenNoCarnivoresLeft", "false");
            float collisionRangeMultiplierOfSumOfRadii = getFloat(appProperties, "collisionRangeMultiplierOfSumOfRadii", "0.5");
            sP = new SimulationParameters(mapWidth, mapHeight, speedOfSimulationMultiplier, startingNumberOfPlants, startingNumberOfHerbivores, startingNumberOfCarnivores, herbivoreSpeed, carnivoreSpeed, plantNutritionalValue, herbivoreStartingEnergy, carnivoreStartingEnergy, herbivoreEnergyConsumptionPerSecond, carnivoreEnergyConsumptionPerSecond, plantRadius, herbivoreRadius, carnivoreRadius, herbivoreSightRange, carnivoreSightRange, baseHerbivoreNutritionalValue, timeToSetNewRandomHerbivoreWanderDirection, timeToSetNewRandomCarnivoreWanderDirection, colourStringOfPlant, colourStringOfHerbivore, colourStringOfCarnivore, useGUI, timeBetweenProgressOutputInTerminal, numberOfPawnsToEndSimulation, endSimulationWhenNoHerbivoresLeft, endSimulationWhenNoCarnivoresLeft, collisionRangeMultiplierOfSumOfRadii);
        }
        catch (IOException | NullPointerException ex) {
            System.out.println("Configuration loading error: " + ex.toString());
        }

        return sP;
    }
}
