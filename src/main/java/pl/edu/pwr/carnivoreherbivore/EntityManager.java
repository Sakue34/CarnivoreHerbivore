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
            for(Entity other: entityList)
                if(entity.x != other.x && entity.y != other.y) {

                    float distanceX = entity.newX - other.newX;
                    float distanceY = entity.newY - other.newY;

                    // Constance to define!
                    if(Math.sqrt(distanceX * distanceX + distanceY * distanceY) < 0.1F )  {
                        entity.collideWithEntity(other);
                    }
                }
        }
        entityList.removeIf(Entity::isToBeDestroyed); //IntelliJ I trust U

    }




}
