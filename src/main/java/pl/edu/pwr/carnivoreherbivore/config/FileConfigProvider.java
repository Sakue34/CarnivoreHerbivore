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
            sP = new SimulationParameters();
            sP.mapHeight = getInt(appProperties, "mapHeight", "800");
            sP.mapWidth = getInt(appProperties, "mapWidth", "1024");
            sP.speedOfSimulationMultiplier = getFloat(appProperties, "speedOfSimulationMultiplier", "1.0");
            sP.startingNumberOfPlants = getInt(appProperties, "startingNumberOfPlants", "60");
            sP.startingNumberOfHerbivores = getInt(appProperties, "startingNumberOfHerbivores", "10");
            sP.startingNumberOfCarnivores = getInt(appProperties, "startingNumberOfCarnivores", "4");
            sP.herbivoreSpeed = getFloat(appProperties, "herbivoreSpeed", "50.0");
            sP.carnivoreSpeed = getFloat(appProperties, "carnivoreSpeed", "60.0");
            sP.plantNutritionalValue = getFloat(appProperties, "plantNutritionalValue", "20.0");
            sP.herbivoreStartingEnergy = getFloat(appProperties, "herbivoreStartingEnergy", "50.0");
            sP.carnivoreStartingEnergy = getFloat(appProperties, "carnivoreStartingEnergy", "50.0");
            sP.herbivoreEnergyConsumptionPerSecond = getFloat(appProperties, "herbivoreEnergyConsumptionPerSecond", "4.0");
            sP.carnivoreEnergyConsumptionPerSecond = getFloat(appProperties, "carnivoreEnergyConsumptionPerSecond", "6.0");
            sP.plantRadius = getInt(appProperties, "plantRadius", "3");
            sP.herbivoreRadius = getInt(appProperties, "herbivoreRadius", "6");
            sP.carnivoreRadius = getInt(appProperties, "carnivoreRadius", "8");
            sP.herbivoreSightRange = getFloat(appProperties, "herbivoreSightRange", "100.0");
            sP.carnivoreSightRange = getFloat(appProperties, "carnivoreSightRange", "100.0");
            sP.baseHerbivoreNutritionalValue = getFloat(appProperties, "baseHerbivoreNutritionalValue", "0.0");
            sP.timeToSetNewRandomHerbivoreWanderDirection = getFloat(appProperties, "timeToSetNewRandomHerbivoreWanderDirection", "4.0");
            sP.timeToSetNewRandomCarnivoreWanderDirection = getFloat(appProperties, "timeToSetNewRandomCarnivoreWanderDirection", "4.0");
            sP.colourStringOfPlant = getString(appProperties, "colourStringOfPlant", "0x7bf542");
            sP.colourStringOfHerbivore = getString(appProperties, "colourStringOfHerbivore", "0x5cc432");
            sP.colourStringOfCarnivore = getString(appProperties, "colourStringOfCarnivore", "0xc70000");
            sP.useGUI = getBoolean(appProperties, "useGUI", "true");
            sP.timeBetweenProgressOutputInTerminal = getFloat(appProperties, "timeBetweenProgressOutputInTerminal", "1.0");
            sP.numberOfPawnsToEndSimulation = getInt(appProperties, "numberOfPawnsToEndSimulation", "10");
            sP.endSimulationWhenNoHerbivoresLeft = getBoolean(appProperties, "endSimulationWhenNoHerbivoresLeft", "true");
            sP.endSimulationWhenNoCarnivoresLeft = getBoolean(appProperties, "endSimulationWhenNoCarnivoresLeft", "false");
            sP.collisionRangeMultiplierOfSumOfRadii = getFloat(appProperties, "collisionRangeMultiplierOfSumOfRadii", "0.5");
        }
        catch (IOException | NullPointerException ex) {
            System.out.println("Configuration loading error: " + ex.toString());
        }

        return sP;
    }
}
