package pl.edu.pwr.carnivoreherbivore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParametersAsker {

    public static void enterParameters() {

        Scanner scan = new Scanner(System.in);

        boolean invalid;

        do {
            invalid = false;
            try {
                System.out.println("Enter the starting number of plants");
                App.setStartingNumberOfPlants(scan.nextInt());

                if(App.getStartingNumberOfPlants() < 0)
                    throw new ArithmeticException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid value type");
                invalid = true;
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("This value cannot be lesser than 0");
                invalid = true;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                invalid = true;
                scan.nextLine();
            }
        } while (invalid);

        do {
            invalid = false;
            try {
                System.out.println("Enter the starting number of herbivores");
                App.setStartingNumberOfHerbivores(scan.nextInt());

                if(App.getStartingNumberOfPlants() < 0)
                    throw new ArithmeticException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid value type");
                invalid = true;
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("This value cannot be lesser than 0");
                invalid = true;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                invalid = true;
                scan.nextLine();
            }
        } while (invalid);

        do {
            invalid = false;
            try {
                System.out.println("Enter the starting number of carnivores");
                App.setStartingNumberOfCarnivores(scan.nextInt());

                if(App.getStartingNumberOfPlants() < 0)
                    throw new ArithmeticException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid value type");
                invalid = true;
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("This value cannot be lesser than 0");
                invalid = true;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                invalid = true;
                scan.nextLine();
            }
        } while (invalid);

        do {
            invalid = false;
            try {
                System.out.println("Enter the width of the map");
                App.setMapWidth(scan.nextInt());

                if(App.getStartingNumberOfPlants() < 0)
                    throw new ArithmeticException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid value type");
                invalid = true;
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("This value cannot be lesser than 0");
                invalid = true;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                invalid = true;
                scan.nextLine();
            }
        } while (invalid);

        do {
            invalid = false;
            try {
                System.out.println("Enter the height of the map");
                App.setMapHeight(scan.nextInt());

                if(App.getStartingNumberOfPlants() < 0)
                    throw new ArithmeticException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid value type");
                invalid = true;
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("This value cannot be lesser than 0");
                invalid = true;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                invalid = true;
                scan.nextLine();
            }
        } while (invalid);

        do {
            invalid = false;
            try {
                System.out.println("Enter the speed of simulation");
                App.setSpeedOfSimulation(scan.nextFloat());

                if(App.getStartingNumberOfPlants() < 0)
                    throw new ArithmeticException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid value type");
                invalid = true;
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("This value cannot be lesser than 0");
                invalid = true;
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                invalid = true;
                scan.nextLine();
            }
        } while (invalid);

        System.out.println("If you want to change the attributes of animals type the name of the animal");

        String animal = scan.nextLine();

        animal.toLowerCase();

        if(animal.equals("herbivore")) {
            if (App.getStartingNumberOfHerbivores() != 0){

            } else {
                System.out.println("There are no herbivores in your simulation");
            }
        }

    }



}
