package pl.edu.pwr.carnivoreherbivore;

import java.util.Scanner;

public class ParametersAsker {

    public static void enterParameters() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the starting number of plants");
            App.setStartingNumberOfPlants(scan.nextInt());
        System.out.println("Enter the starting number of herbivores");
            App.setStartingNumberOfHerbivores(scan.nextInt());
        System.out.println("Enter the starting number of carnivores");
            App.setStartingNumberOfCarnivores(scan.nextInt());
        System.out.println("Enter the width of the map");
            App.setMapWidth(scan.nextInt());
        System.out.println("Enter the height of the map");
            App.setMapHeight(scan.nextInt());
        System.out.println("Enter the speed of simulation");
            App.setSpeedOfSimulation(scan.nextFloat());
    }

}
