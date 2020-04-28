package pl.edu.pwr.carnivoreherbivore;

import java.lang.System;
import java.util.Scanner;

public class App {
    private static float speedOfSimulation = 1.0F;
    private static int startingNumberOfCarnivores = 10;
    private static int startingNumberOfHerbivores = 15;
    private static int startingNumberOfPlants = 40;

    public static final int MAP_WIDTH = 400;
    public static final int MAP_HEIGHT = 400;

    private static void startSimulation() throws InterruptedException {
        EntityManager entityManager = new EntityManager(startingNumberOfPlants, startingNumberOfHerbivores, startingNumberOfCarnivores);

        long time1 = System.nanoTime();
        long time2;

        float logRefreshTimer = 3.0F;

        while (true) {
            time2 = System.nanoTime();
            long elapsedNanoSeconds = time2 - time1;
            time1 = time2;
            float elapsedTime = (float)elapsedNanoSeconds / 1.0e9F;
            elapsedTime *= speedOfSimulation;

            entityManager.updateEveryEntity(elapsedTime);

            //Test:
            Thread.sleep(10);
            //System.out.println(elapsedTime);

            //Scanner scanner = new Scanner(System.in);
            //String buffer = scanner.nextLine();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        startSimulation();
    }
}
