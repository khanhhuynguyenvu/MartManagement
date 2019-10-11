package group.jpa.ogm.app.repository.goods;

import group.jpa.ogm.app.entities.Good;

public interface GoodRepository {
    void save(Good good);

    Good find(String id);

    void update(Good good);

    void remove(Good good);
}
