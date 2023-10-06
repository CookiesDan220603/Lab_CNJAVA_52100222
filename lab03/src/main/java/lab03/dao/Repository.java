package lab03.dao;
import lab03.domain.Manufacture;

import java.util.List;

public interface Repository <T, K>{
    boolean add(T item);
    List<T> readAll();
    T read(K id);

    Manufacture read(int id);

    boolean update(T item);
    boolean delete(K id);

    boolean delete(int id);
}

