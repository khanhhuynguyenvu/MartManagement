package group.jpa.ogm.app.repository.goods;

import org.springframework.stereotype.Component;

import group.jpa.ogm.app.entities.Good;
import group.jpa.ogm.app.repository.generics.GenericsDAOImpl;

@Component
public class GoodDAOImpl extends GenericsDAOImpl<Good> implements GoodDAO {
}
