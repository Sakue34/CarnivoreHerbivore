package pl.edu.pwr.carnivoreherbivore;

import java.lang.System;

public class App {
    private static float speedOfSimulation;
    private static int startingNumberOfCarnivores;
    private static int startingNumberOfHerbivores;
    private static int startingNumberOfPlants;
    private static int MAP_WIDTH;
    private static int MAP_HEIGHT;

    private static void startSimulation() {
        EntityManager entityManager = new EntityManager(getStartingNumberOfPlants(), getStartingNumberOfHerbivores(), getStartingNumberOfCarnivores());

        long time1 = System.nanoTime();
        long time2;

        while (true) {
            time2 = System.nanoTime();
            long elapsedNanoSeconds = time2 - time1;
            time1 = time2;
            float elapsedTime = (float)elapsedNanoSeconds / 1.0e9F;
            elapsedTime *= getSpeedOfSimulation();

            entityManager.updateEveryEntity(elapsedTime);
        }
    }
    public static void main(String[] args) {

        ParametersAsker.enterParameters();
        startSimulation();
    }

    public static void setSpeedOfSimulation(float speedOfSimulation) {
        App.speedOfSimulation = speedOfSimulation;
    }

    public static void setStartingNumberOfCarnivores(int startingNumberOfCarnivores) {
        App.startingNumberOfCarnivores = startingNumberOfCarnivores;
    }

    public static void setStartingNumberOfHerbivores(int startingNumberOfHerbivores) {
        App.startingNumberOfHerbivores = startingNumberOfHerbivores;
    }

    public static void setStartingNumberOfPlants(int startingNumberOfPlants) {
        App.startingNumberOfPlants = startingNumberOfPlants;
    }

    public static void setMapWidth(int mapWidth) {
        MAP_WIDTH = mapWidth;
    }

    public static void setMapHeight(int mapHeight) {
        MAP_HEIGHT = mapHeight;
    }

    public static int getMapWidth() {
        return MAP_WIDTH;
    }

    public static int getMapHeight() {
        return MAP_HEIGHT;
    }

    public static float getSpeedOfSimulation() {
        return speedOfSimulation;
    }

    public static int getStartingNumberOfCarnivores() {
        return startingNumberOfCarnivores;
    }

    public static int getStartingNumberOfHerbivores() {
        return startingNumberOfHerbivores;
    }

    public static int getStartingNumberOfPlants() {
        return startingNumberOfPlants;
    }
}
