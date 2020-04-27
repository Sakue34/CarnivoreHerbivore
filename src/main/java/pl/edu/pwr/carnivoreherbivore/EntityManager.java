package pl.edu.pwr.carnivoreherbivore;

import java.util.ArrayList;

class EntityManager {
    private ArrayList<Entity> entityList;

    void addEntity(Entity entity) {
        entityList.add(entity);
    }

    EntityManager(int initialNumberOfEntities) {
        entityList = new ArrayList<>(initialNumberOfEntities);
    }

    void updateEveryEntity(float elapsedTime) {

    }


}
