package dao;


import java.util.List;

public interface IDao<T> {
    int insert(T t);
    int delete(T t);
    int update(T t);
    List<T> query(T t);
    List<T> queryAll();
}
