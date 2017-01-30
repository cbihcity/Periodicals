package by.pvt.heldyieu.dao.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {
	
	 /** Создает новую запись и соответствующий ей объект */
    public T create();

    /** Создает новую запись, соответствующую объекту object */
    public T persist(T object);

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(PK key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(T object);

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll();
}
