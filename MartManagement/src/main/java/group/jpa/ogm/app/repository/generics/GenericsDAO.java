package group.jpa.ogm.app.repository.generics;

public interface GenericsDAO<T> {
	T findById(String id,Class<T> t);
    void save(T t);
    void remove(T t);
    void update(T t);
}
