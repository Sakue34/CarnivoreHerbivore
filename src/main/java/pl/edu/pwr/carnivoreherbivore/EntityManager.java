package pl.edu.pwr.carnivoreherbivore;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entityList;

    public void addEntity(Entity entity) {
        entityList.add(entity);
    }

    public EntityManager(int numberOfPlants, int numberOfHerbivores, int numberOfCarnivores) {
        entityList = new ArrayList<>(numberOfPlants + numberOfHerbivores + numberOfCarnivores);

        for(int i = 0; i < numberOfPlants; i++) {
            entityList.add(new Plant((float)(Math.random() * App.MAP_WIDTH),
                    (float)(Math.random() * App.MAP_HEIGHT)));
        }

        for(int i = 0; i < numberOfHerbivores; i++) {
            entityList.add(new Herbivore((float)(Math.random() * App.MAP_WIDTH),
                    (float)(Math.random() * App.MAP_HEIGHT)));
        }

        for(int i = 0; i < numberOfCarnivores; i++) {
            entityList.add(new Carnivore((float)(Math.random() * App.MAP_WIDTH),
                    (float)(Math.random() * App.MAP_HEIGHT)));
        }
    }

    //temp
    private float timeToNextLog = 1.0F;

    public void updateEveryEntity(float elapsedTime) {
        for(Entity entity: entityList) {
            for(Entity other: entityList) {
                if (entity.x != other.x && entity.y != other.y) {

                    // Constant to define!
                    if (Entity.getDistanceBetween(entity, other) < 1.0F) {
                        entity.collideWithEntity(other);
                    }
                }
            }
        }

        for(Entity entity: entityList) {
            entity.updatePositionNewXY(elapsedTime);
        }

        entityList.removeIf(Entity::isToBeDestroyed); //IntelliJ I trust U

        for (Entity entity: entityList) {
            if (entity instanceof Carnivore) {
                Herbivore nearestHerbivore = null;
                float nearestHerbivoreDistance = 0.0F;
                for (Entity other: entityList) {
                    if (other instanceof Herbivore) {
                        float distanceBetween = Entity.getDistanceBetweenNewXY(entity, other);

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
                entity.updateAI(nearestHerbivore, elapsedTime);
            }
            else if (entity instanceof Herbivore) {
                Carnivore nearestCarnivore = null;
                float nearestPlantDistance = 0.0F;

                Plant nearestPlant = null;
                float nearestCarnivoreDistance = 0.0F;

                for (Entity other: entityList) {
                    if (other instanceof Plant) {
                        float distanceBetween = Entity.getDistanceBetweenNewXY(entity, other);
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
                        float distanceBetween = Entity.getDistanceBetweenNewXY(entity, other);
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
                    entity.updateAI(nearestCarnivore, elapsedTime);
                } else {
                    entity.updateAI(nearestPlant, elapsedTime);
                }
            }
        }

        for(Entity entity : entityList) {
            entity.updateFinalPosition();
        }

        timeToNextLog -= elapsedTime;
        if(timeToNextLog <= 0.0F) {
            System.out.println("=========================================");
            for (int i = 0; i < entityList.size(); i++) {
                System.out.println(i + ": " + entityList.get(i).toString());
            }
            timeToNextLog = 1.0F;
        }
    }
    
}

