package pl.edu.pwr.carnivoreherbivore;

import java.util.ArrayList;

public class PawnManager {
    public ArrayList<Pawn> getPawnList() {
        return pawnList;
    }

    private ArrayList<Pawn> pawnList;

    public void addEntity(Pawn pawn) {
        pawnList.add(pawn);
    }

    public PawnManager(int numberOfPlants, int numberOfHerbivores, int numberOfCarnivores) {
        pawnList = new ArrayList<>(numberOfPlants + numberOfHerbivores + numberOfCarnivores);

        for(int i = 0; i < numberOfPlants; i++) {
            pawnList.add(new Plant((float)(Math.random() * App.getMapWidth()),
                    (float)(Math.random() * App.getMapHeight())));
        }

        for(int i = 0; i < numberOfHerbivores; i++) {
            pawnList.add(new Herbivore((float)(Math.random() * App.getMapWidth()),
                    (float)(Math.random() * App.getMapHeight())));
        }

        for(int i = 0; i < numberOfCarnivores; i++) {
            pawnList.add(new Carnivore((float)(Math.random() * App.getMapWidth()),
                    (float)(Math.random() * App.getMapHeight())));
        }
    }

    //temp
    private float timeToNextLog = 1.0F;

    public void updateEveryEntity(float elapsedTime) {
        for(Pawn pawn : pawnList) {
            for(Pawn other: pawnList) {
                if (pawn.x != other.x && pawn.y != other.y) {

                    // Constant to define!
                    if (Pawn.getDistanceBetween(pawn, other) < 1.0F) {
                        pawn.collideWithEntity(other);
                    }
                }
            }
        }

        for(Pawn pawn : pawnList) {
            pawn.updatePositionNewXY(elapsedTime);
        }

        pawnList.removeIf(Pawn::isToBeDestroyed); //IntelliJ I trust U

        for (Pawn pawn : pawnList) {
            if (pawn instanceof Carnivore) {
                Herbivore nearestHerbivore = null;
                float nearestHerbivoreDistance = 0.0F;
                for (Pawn other: pawnList) {
                    if (other instanceof Herbivore) {
                        float distanceBetween = Pawn.getDistanceBetweenNewXY(pawn, other);

                        if (distanceBetween <= Carnivore.rangeOfVision) {
                            if (nearestHerbivore != null) {
                                if (distanceBetween < nearestHerbivoreDistance) {
                                    nearestHerbivore = (Herbivore) other;
                                    nearestHerbivoreDistance = distanceBetween;
                                }
                            }
                            else {
                                nearestHerbivore = (Herbivore) other;
                                nearestHerbivoreDistance = distanceBetween;
                            }
                        }
                    }
                }
                pawn.updateAI(nearestHerbivore, elapsedTime);
            }
            else if (pawn instanceof Herbivore) {
                Carnivore nearestCarnivore = null;
                float nearestPlantDistance = 0.0F;

                Plant nearestPlant = null;
                float nearestCarnivoreDistance = 0.0F;

                for (Pawn other: pawnList) {
                    if (other instanceof Plant) {
                        float distanceBetween = Pawn.getDistanceBetweenNewXY(pawn, other);
                        if (distanceBetween <= Herbivore.rangeOfVision) {
                            if (nearestPlant != null) {
                                if (distanceBetween < nearestPlantDistance) {
                                    nearestPlant = (Plant) other;
                                    nearestPlantDistance = distanceBetween;
                                }
                            }
                            else {
                                nearestPlant = (Plant) other;
                                nearestPlantDistance = distanceBetween;
                            }
                        }
                    } else if (other instanceof Carnivore) {
                        float distanceBetween = Pawn.getDistanceBetweenNewXY(pawn, other);
                        if (distanceBetween <= Herbivore.rangeOfVision) {
                            if (nearestCarnivore != null) {
                                if (distanceBetween < nearestCarnivoreDistance) {
                                    nearestCarnivore = (Carnivore) other;
                                    nearestCarnivoreDistance = distanceBetween;
                                }
                            }
                            else {
                                nearestCarnivore = (Carnivore) other;
                                nearestCarnivoreDistance = distanceBetween;
                            }
                        }

                    }
                }
                if (nearestCarnivore != null) {
                    pawn.updateAI(nearestCarnivore, elapsedTime);
                } else {
                    pawn.updateAI(nearestPlant, elapsedTime);
                }
            }
        }

        for(Pawn pawn : pawnList) {
            pawn.updateFinalPosition();
        }

        timeToNextLog -= elapsedTime;
        if(timeToNextLog <= 0.0F) {
            System.out.println("=========================================");
            for (int i = 0; i < pawnList.size(); i++) {
                System.out.println(i + ": " + pawnList.get(i).toString());
            }
            timeToNextLog = 1.0F;
        }
    }
    
}

