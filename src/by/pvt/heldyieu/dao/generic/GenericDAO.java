package by.pvt.heldyieu.dao.generic;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {
	
    /** Создает новую запись, соответствующую объекту object */
    public T create(T object) throws SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(PK key) throws SQLException;

    /** Сохраняет состояние объекта group в базе данных */
    public void update(T object) throws SQLException;

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll() throws SQLException;
}
