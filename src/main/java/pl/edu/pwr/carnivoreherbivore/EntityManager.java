package pl.edu.pwr.carnivoreherbivore;

import java.util.ArrayList;
import java.lang.Math;

public class EntityManager {
    private ArrayList<Entity> entityList;

    public void addEntity(Entity entity) {
        entityList.add(entity);
    }

    public EntityManager(int initialNumberOfEntities) {
        entityList = new ArrayList<>(initialNumberOfEntities);
    }

    public void updateEveryEntity(float elapsedTime) {
        for(Entity entity: entityList) {
            entity.updatePosition(elapsedTime);
        }

        for(Entity entity: entityList) {
            for(Entity other: entityList) {
                if (entity.x != other.x && entity.y != other.y) {

                    // Constant to define!
                    if (Entity.getDistanceBetweenNewXY(entity, other) < 0.1F) {
                        entity.collideWithEntity(other);
                    }
                }
            }
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
                entity.updateAI(nearestHerbivore);
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
                    entity.updateAI(nearestCarnivore);
                } else {
                    entity.updateAI(nearestPlant);
                }
            }
        }
    }
    
}

