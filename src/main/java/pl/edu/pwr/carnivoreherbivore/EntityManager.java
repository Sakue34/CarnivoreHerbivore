package pl.edu.pwr.carnivoreherbivore;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entityList;

    public void AddEntity(Entity entity) {
        entityList.add(entity);
    }

    public EntityManager(int initialNumberOfEntities) {
        entityList = new ArrayList<>(initialNumberOfEntities);
    }

    public void UpdateEveryEntity(float elapsedTime) {

    }

}
