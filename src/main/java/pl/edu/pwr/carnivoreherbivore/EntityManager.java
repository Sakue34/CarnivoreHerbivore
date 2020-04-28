package pl.edu.pwr.carnivoreherbivore;

import java.util.ArrayList;

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
    }


}
